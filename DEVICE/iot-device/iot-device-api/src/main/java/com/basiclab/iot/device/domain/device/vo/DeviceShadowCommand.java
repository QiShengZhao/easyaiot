package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class DeviceShadowCommand {
    @Schema(description = "命令名称")
    private String commandName;

    @Schema(description = "命令名称")
    private String commandCode;

    @Schema(description = "命令参数")
    @NotNull(message = "命令参数不能为空")
    private Map<String, Object> params;
}
