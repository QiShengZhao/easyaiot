package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;

/**
 * -----------------------------------------------------------------------------
 * 文件名称: CommandIssueRequestParam.java
 * -----------------------------------------------------------------------------
 * 描述:
 * Platform Command Issue Request Data Model
 * -----------------------------------------------------------------------------
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @version 1.0
 * -----------------------------------------------------------------------------
 * 修改历史:
 * 日期           作者          版本        描述
 * --------      --------     -------   --------------------
 * <p>
 * -----------------------------------------------------------------------------
 * @email andywebjava@163.com
 * @date 2023-10-17 09:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
@Schema(description = "Device Command Request Data Structure")
public class CommandIssueRequestParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "设备标识", hidden = true)
    private String deviceIdentification;

    @Schema(description = "产品标识", hidden = true)
    private String productIdentification;

    @Schema(description = "消息类型")
    @NotEmpty(message = "消息类型不能为空")
    private String msgType;

    @Schema(description = "msgId.（msgId.）")
    private String msgId;

    @Schema(description = "服务标识")
    @NotEmpty(message = "服务标识不能为空")
    private String serviceCode;

    @Schema(description = "命令名称")
    @NotEmpty(message = "命令名称不能为空")
    private String commandName;

    @Schema(description = "命令名称")
    @NotEmpty(message = "命令名称不能为空")
    private String commandCode;

    @Schema(description = "命令参数")
    @NotNull(message = "命令参数不能为空")
    private Map<String, Object> params;
}
