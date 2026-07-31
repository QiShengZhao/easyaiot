package com.basiclab.iot.common.service;

import cn.hutool.core.util.StrUtil;
import com.basiclab.iot.common.domain.LoginUser;
import com.basiclab.iot.common.utils.SecurityFrameworkUtils;
import com.basiclab.iot.common.utils.servlet.ServletUtils;
import com.basiclab.iot.system.api.logger.OperateLogApi;
import com.basiclab.iot.system.api.logger.dto.OperateLogCreateReqDTO;
import com.mzt.logapi.beans.LogRecord;
import com.mzt.logapi.service.ILogRecordService;
import lombok.extern.slf4j.Slf4j;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 操作日志 ILogRecordService 实现类
 * <p>
 * 基于 {@link OperateLogApi} 实现，记录操作日志
 *
 * @author HUIHUI
 */
@Slf4j
public class LogRecordServiceImpl implements ILogRecordService {

    @Resource
    private OperateLogApi operateLogApi;

    @Override
    public void record(LogRecord logRecord) {
        try {
            // 1. 补全通用字段
            OperateLogCreateReqDTO reqDTO = new OperateLogCreateReqDTO();
            reqDTO.setTraceId("");
            // 补充用户信息
            fillUserFields(reqDTO);
            if (reqDTO.getUserId() == null || reqDTO.getUserType() == null) {
                log.warn("[record][跳过操作日志，无登录用户] type={} subType={}",
                        logRecord.getType(), logRecord.getSubType());
                return;
            }
            // 补全模块信息
            fillModuleFields(reqDTO, logRecord);
            // 补全请求信息
            fillRequestFields(reqDTO);
            // RPC DTO 若干字段为 @NotEmpty，缺省时补空串，避免落库失败
            if (StrUtil.isEmpty(reqDTO.getRequestMethod())) {
                reqDTO.setRequestMethod("-");
            }
            if (StrUtil.isEmpty(reqDTO.getRequestUrl())) {
                reqDTO.setRequestUrl("-");
            }
            if (StrUtil.isEmpty(reqDTO.getUserIp())) {
                reqDTO.setUserIp("127.0.0.1");
            }
            if (StrUtil.isEmpty(reqDTO.getUserAgent())) {
                reqDTO.setUserAgent("-");
            }
            if (StrUtil.isEmpty(reqDTO.getAction())) {
                reqDTO.setAction(StrUtil.blankToDefault(logRecord.getAction(), "-"));
            }
            if (reqDTO.getExtra() == null) {
                reqDTO.setExtra("");
            }

            // 2. 记录日志
            operateLogApi.createOperateLog(reqDTO);
        } catch (Exception ex) {
            // 操作日志失败不应影响主业务
            log.error("[record][记录操作日志失败] type={} subType={} bizNo={}",
                    logRecord.getType(), logRecord.getSubType(), logRecord.getBizNo(), ex);
        }
    }

    private static void fillUserFields(OperateLogCreateReqDTO reqDTO) {
        // 使用 SecurityFrameworkUtils。因为要考虑，rpc、mq、job，它其实不是 web；
        LoginUser loginUser = SecurityFrameworkUtils.getLoginUser();
        if (loginUser == null) {
            return;
        }
        reqDTO.setUserId(loginUser.getId());
        reqDTO.setUserType(loginUser.getUserType());
    }

    public static void fillModuleFields(OperateLogCreateReqDTO reqDTO, LogRecord logRecord) {
        reqDTO.setType(logRecord.getType()); // 大模块类型，例如：CRM 客户
        reqDTO.setSubType(logRecord.getSubType());// 操作名称，例如：转移客户
        String bizNo = logRecord.getBizNo();
        long bizId = 0L;
        if (StrUtil.isNotBlank(bizNo)) {
            try {
                bizId = Long.parseLong(bizNo.trim());
            } catch (NumberFormatException ignored) {
                bizId = 0L;
            }
        }
        reqDTO.setBizId(bizId); // 业务编号，例如：客户编号
        reqDTO.setAction(logRecord.getAction());// 操作内容，例如：修改编号为 1 的用户信息，将性别从男改成女，将姓名从BasicLab改成源码。
        reqDTO.setExtra(logRecord.getExtra()); // 拓展字段，有些复杂的业务，需要记录一些字段 ( JSON 格式 )，例如说，记录订单编号，{ orderId: "1"}
    }

    private static void fillRequestFields(OperateLogCreateReqDTO reqDTO) {
        // 获得 Request 对象
        HttpServletRequest request = ServletUtils.getRequest();
        if (request == null) {
            return;
        }
        // 补全请求信息
        reqDTO.setRequestMethod(request.getMethod());
        reqDTO.setRequestUrl(request.getRequestURI());
        reqDTO.setUserIp(ServletUtils.getClientIP(request));
        reqDTO.setUserAgent(ServletUtils.getUserAgent(request));
    }

    @Override
    public List<LogRecord> queryLog(String bizNo, String type) {
        throw new UnsupportedOperationException("使用 OperateLogApi 进行操作日志的查询");
    }

    @Override
    public List<LogRecord> queryLogByBizNo(String bizNo, String type, String subType) {
        throw new UnsupportedOperationException("使用 OperateLogApi 进行操作日志的查询");
    }

}