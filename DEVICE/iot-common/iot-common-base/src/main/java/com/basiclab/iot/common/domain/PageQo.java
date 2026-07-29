package com.basiclab.iot.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-05-27
 */
@Data
@NoArgsConstructor
@Schema(description = "用于指定分页查询相关参数")
public class PageQo implements Serializable {

    @Schema(description = "当前页", example = "1")
    protected int pageNo = 1;

    @Schema(description = "每页显示大小", example = "10")
    protected int pageSize = 10;

    @Schema(description = "排序字段列表")
    protected List<SortOrder> sortOrders = new ArrayList<>();

    public void addSortOrder(String property, Direction direction) {
        this.sortOrders.add(new SortOrder(property, direction));
    }

    public void addSortOrder(String property, String direction) {
        this.sortOrders.add(new SortOrder(property, Direction.fromStringOrNull(direction)));
    }

    public PageQo(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
