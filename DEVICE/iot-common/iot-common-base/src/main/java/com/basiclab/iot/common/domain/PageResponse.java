package com.basiclab.iot.common.domain;

import com.basiclab.iot.common.exception.BaseException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-05-27
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "用于返回分页查询响应的内容")
public class PageResponse<T> {

    @Schema(description = "请求响应状态码，0-成功，-1-未知，其他自定义", example = "0")
    private Integer code = 0;

    @Schema(description = "请求响应消息", example = "")
    private String message = "";

    @Schema(description = "请求响应数据")
    private List<T> data;

    @Schema(description = "总记录数", example = "100")
    private long total;

    @Schema(description = "总页数", example = "10")
    private long totalPages;

    @Schema(description = "当前页", example = "1")
    private int pageNo = 1;

    @Schema(description = "每页显示记录数", example = "10")
    private int pageSize = 10;

    public PageResponse() {
        this(0, 1, 10);
    }

    public PageResponse(long total, int pageNo, int pageSize) {
        this(null, total, pageNo, pageSize);
    }

    public PageResponse(List<T> data, long total, int pageNo, int pageSize) {
        this.data = data;
        this.total = total;
        this.totalPages = (total + pageSize - 1) / pageSize;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public static PageResponse success() {
        return new PageResponse();
    }

    public static <T> PageResponse success(List<T> data, long total, PageQo pageQo) {
        return new PageResponse(data, total, pageQo.getPageNo(), pageQo.getPageSize());
    }

    public static <T> PageResponse success(List<T> data, long total, int pageNo, int pageSize) {
        return new PageResponse(data, total, pageNo, pageSize);
    }

    public static <T> PageResponse success(PageInfo<T> pageInfo) {
        return new PageResponse(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize());
    }

    public static <T> PageResponse success(List<T> data, PageResponse pageResponse) {
        return new PageResponse(data, pageResponse.getTotal(), pageResponse.getPageNo(), pageResponse.getPageSize());
    }

    public static PageResponse error() {
        PageResponse response = new PageResponse();
        response.setCode(-1);
        return response;
    }

    public static PageResponse error(BaseException ex) {
        PageResponse response = new PageResponse();
        response.setCode(Integer.parseInt(ex.getCode()));
        response.setMessage(ex.getMessage());
        return response;
    }
}
