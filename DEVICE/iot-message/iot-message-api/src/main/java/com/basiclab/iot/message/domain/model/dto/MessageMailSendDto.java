package com.basiclab.iot.message.domain.model.dto;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 消息发送DTO
 * 支持所有消息类型的发送参数
 * 
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-07-22
 */
@Data
@Tag(name  ="消息发送")
public class MessageMailSendDto {

    @Schema(description = "消息id")
    private String msgId;

    @Schema(description = "消息类型")
    private Integer msgType;

    @Schema(description = "消息内容")
    private String content;

    // ========== HTTP/Webhook 相关字段 ==========
    @Schema(description = "HTTP请求方法 (GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS)")
    private String method;

    @Schema(description = "HTTP请求URL")
    private String url;

    @Schema(description = "HTTP请求体 (JSON字符串)")
    private String body;

    @Schema(description = "HTTP请求体类型 (application/json, text/plain等)")
    private String bodyType;

    @Schema(description = "HTTP请求参数 (JSON字符串，格式: [{\"name\":\"key\",\"value\":\"value\"}] 或 {\"key\":\"value\"})")
    private String params;

    @Schema(description = "HTTP请求头 (JSON字符串，格式: [{\"name\":\"key\",\"value\":\"value\"}] 或 {\"key\":\"value\"})")
    private String headers;

    @Schema(description = "HTTP Cookie (JSON字符串，格式: [{\"name\":\"key\",\"value\":\"value\",\"domain\":\"\",\"path\":\"\",\"time\":\"\"}])")
    private String cookies;

    // ========== 其他通用字段 ==========
    @Schema(description = "消息名称")
    private String msgName;

    @Schema(description = "用户组ID")
    private String userGroupId;

    @Schema(description = "预览用户")
    private String previewUser;

}
