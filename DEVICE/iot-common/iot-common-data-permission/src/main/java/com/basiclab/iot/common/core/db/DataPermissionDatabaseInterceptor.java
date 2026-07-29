package com.basiclab.iot.common.core.db;

import cn.hutool.core.collection.CollUtil;
import com.basiclab.iot.common.utils.collection.SetUtils;
import com.basiclab.iot.common.core.rule.DataPermissionRule;
import com.basiclab.iot.common.core.rule.DataPermissionRuleFactory;
import com.basiclab.iot.common.core.util.MyBatisUtils;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.inner.BaseMultiTableInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.WithItem;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据权限拦截器，通过 {@link DataPermissionRule} 数据权限规则，重写 SQL 的方式来实现
 * 主要的 SQL 重写方法，可见 {@link #buildTableExpression(Table, Expression, String)} 方法
 *
 * 整体的代码实现上，参考 {@link com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor} 实现。
 * 所以每次 MyBatis Plus 升级时，需要 Review 下其具体的实现是否有变更！
 * （Boot3 迁移说明：MP 3.5.17 + jsqlparser 4.9 已把多表遍历逻辑抽取到 {@link BaseMultiTableInnerInterceptor}，
 * 本类改为继承该基类，仅保留数据权限条件的构建逻辑）
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DataPermissionDatabaseInterceptor extends BaseMultiTableInnerInterceptor implements InnerInterceptor {

    private final DataPermissionRuleFactory ruleFactory;

    @Getter
    private final MappedStatementCache mappedStatementCache = new MappedStatementCache();

    public DataPermissionDatabaseInterceptor(DataPermissionRuleFactory ruleFactory) {
        this.ruleFactory = ruleFactory;
    }

    @Override // SELECT 场景
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        // 获得 Mapper 对应的数据权限的规则
        List<DataPermissionRule> rules = ruleFactory.getDataPermissionRule(ms.getId());
        if (mappedStatementCache.noRewritable(ms, rules)) { // 如果无需重写，则跳过
            return;
        }

        PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);
        try {
            // 初始化上下文
            ContextHolder.init(rules);
            // 处理 SQL
            mpBs.sql(parserSingle(mpBs.sql(), null));
        } finally {
            // 添加是否需要重写的缓存
            addMappedStatementCache(ms);
            // 清空上下文
            ContextHolder.clear();
        }
    }

    @Override // 只处理 UPDATE / DELETE 场景，不处理 INSERT 场景（因为 INSERT 不需要数据权限)
    public void beforePrepare(StatementHandler sh, Connection connection, Integer transactionTimeout) {
        PluginUtils.MPStatementHandler mpSh = PluginUtils.mpStatementHandler(sh);
        MappedStatement ms = mpSh.mappedStatement();
        SqlCommandType sct = ms.getSqlCommandType();
        if (sct == SqlCommandType.UPDATE || sct == SqlCommandType.DELETE) {
            // 获得 Mapper 对应的数据权限的规则
            List<DataPermissionRule> rules = ruleFactory.getDataPermissionRule(ms.getId());
            if (mappedStatementCache.noRewritable(ms, rules)) { // 如果无需重写，则跳过
                return;
            }

            PluginUtils.MPBoundSql mpBs = mpSh.mPBoundSql();
            try {
                // 初始化上下文
                ContextHolder.init(rules);
                // 处理 SQL
                mpBs.sql(parserMulti(mpBs.sql(), null));
            } finally {
                // 添加是否需要重写的缓存
                addMappedStatementCache(ms);
                // 清空上下文
                ContextHolder.clear();
            }
        }
    }

    @Override
    protected void processSelect(Select select, int index, String sql, Object obj) {
        final String whereSegment = (String) obj;
        processSelectBody(select, whereSegment);
        List<WithItem> withItemsList = select.getWithItemsList();
        if (!CollectionUtils.isEmpty(withItemsList)) {
            withItemsList.forEach(withItem -> processSelectBody(withItem, whereSegment));
        }
    }

    /**
     * update 语句处理
     */
    @Override
    protected void processUpdate(Update update, int index, String sql, Object obj) {
        final Table table = update.getTable();
        update.setWhere(this.andExpression(table, update.getWhere(), (String) obj));
    }

    /**
     * delete 语句处理
     */
    @Override
    protected void processDelete(Delete delete, int index, String sql, Object obj) {
        delete.setWhere(this.andExpression(delete.getTable(), delete.getWhere(), (String) obj));
    }

    // ========== 和 TenantLineInnerInterceptor 存在差异的逻辑：关键，实现权限条件的拼接 ==========

    /**
     * 构建指定表的数据权限的 Expression 过滤条件
     *
     * @param table        表
     * @param where        当前 where 条件
     * @param whereSegment 所属 Mapper 全路径（数据权限场景不参与判断）
     * @return Expression 过滤条件
     */
    @Override
    public Expression buildTableExpression(final Table table, final Expression where, final String whereSegment) {
        // 生成条件
        Expression allExpression = null;
        for (DataPermissionRule rule : ContextHolder.getRules()) {
            // 判断表名是否匹配
            String tableName = MyBatisUtils.getTableName(table);
            if (!rule.getTableNames().contains(tableName)) {
                continue;
            }
            // 如果有匹配的规则，说明可重写。
            // 为什么不是有 allExpression 非空才重写呢？在生成 column = value 过滤条件时，会因为 value 不存在，导致未重写。
            // 这样导致第一次无 value，被标记成无需重写；但是第二次有 value，此时会需要重写。
            ContextHolder.setRewrite(true);

            // 单条规则的条件
            Expression oneExpress = rule.getExpression(tableName, table.getAlias());
            if (oneExpress == null){
                continue;
            }
            // 拼接到 allExpression 中
            allExpression = allExpression == null ? oneExpress
                    : new AndExpression(allExpression, oneExpress);
        }

        return allExpression;
    }

    /**
     * 判断 SQL 是否重写。如果没有重写，则添加到 {@link MappedStatementCache} 中
     *
     * @param ms MappedStatement
     */
    private void addMappedStatementCache(MappedStatement ms) {
        if (ContextHolder.getRewrite()) {
            return;
        }
        // 无重写，进行添加
        mappedStatementCache.addNoRewritable(ms, ContextHolder.getRules());
    }

    /**
     * SQL 解析上下文，方便透传 {@link DataPermissionRule} 规则
     *
     * @author 翱翔的雄库鲁
     * @email andywebjava@163.com
     * @wechat EasyAIoT2025
     */
    static final class ContextHolder {

        /**
         * 该 {@link MappedStatement} 对应的规则
         */
        private static final ThreadLocal<List<DataPermissionRule>> RULES = ThreadLocal.withInitial(Collections::emptyList);
        /**
         * SQL 是否进行重写
         */
        private static final ThreadLocal<Boolean> REWRITE = ThreadLocal.withInitial(() -> Boolean.FALSE);

        public static void init(List<DataPermissionRule> rules) {
            RULES.set(rules);
            REWRITE.set(false);
        }

        public static void clear() {
            RULES.remove();
            REWRITE.remove();
        }

        public static boolean getRewrite() {
            return REWRITE.get();
        }

        public static void setRewrite(boolean rewrite) {
            REWRITE.set(rewrite);
        }

        public static List<DataPermissionRule> getRules() {
            return RULES.get();
        }

    }

    /**
     * {@link MappedStatement} 缓存
     * 目前主要用于，记录 {@link DataPermissionRule} 是否对指定 {@link MappedStatement} 无效
     * 如果无效，则可以避免 SQL 的解析，加快速度
     *
     * @author 翱翔的雄库鲁
     * @email andywebjava@163.com
     * @wechat EasyAIoT2025
     */
    static final class MappedStatementCache {

        /**
         * 指定数据权限规则，对指定 MappedStatement 无需重写（不生效)的缓存
         *
         * value：{@link MappedStatement#getId()} 编号
         */
        @Getter
        private final Map<Class<? extends DataPermissionRule>, Set<String>> noRewritableMappedStatements = new ConcurrentHashMap<>();

        /**
         * 判断是否无需重写
         * ps：虽然有点中文式英语，但是容易读懂即可
         *
         * @param ms MappedStatement
         * @param rules 数据权限规则数组
         * @return 是否无需重写
         */
        public boolean noRewritable(MappedStatement ms, List<DataPermissionRule> rules) {
            // 如果规则为空，说明无需重写
            if (CollUtil.isEmpty(rules)) {
                return true;
            }
            // 任一规则不在 noRewritableMap 中，则说明可能需要重写
            for (DataPermissionRule rule : rules) {
                Set<String> mappedStatementIds = noRewritableMappedStatements.get(rule.getClass());
                if (!CollUtil.contains(mappedStatementIds, ms.getId())) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 添加无需重写的 MappedStatement
         *
         * @param ms MappedStatement
         * @param rules 数据权限规则数组
         */
        public void addNoRewritable(MappedStatement ms, List<DataPermissionRule> rules) {
            for (DataPermissionRule rule : rules) {
                Set<String> mappedStatementIds = noRewritableMappedStatements.get(rule.getClass());
                if (CollUtil.isNotEmpty(mappedStatementIds)) {
                    mappedStatementIds.add(ms.getId());
                } else {
                    noRewritableMappedStatements.put(rule.getClass(), SetUtils.asSet(ms.getId()));
                }
            }
        }

        /**
         * 清空缓存
         * 目前主要提供给单元测试
         */
        public void clear() {
            noRewritableMappedStatements.clear();
        }

    }

}
