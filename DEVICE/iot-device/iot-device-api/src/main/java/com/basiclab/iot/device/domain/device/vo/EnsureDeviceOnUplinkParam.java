package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 上行时若设备不存在则按产品自动建档（GATEWAY / COMMON）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Schema(description = "上行自动创建设备参数")
public class EnsureDeviceOnUplinkParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "产品标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "产品标识不能为空")
    private String productIdentification;

    @Schema(description = "设备标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "设备标识不能为空")
    private String deviceIdentification;

    @Schema(description = "设备名称（新建时可选）")
    private String deviceName;

    @Schema(description = "MQTT ClientId（新建时可选）")
    private String clientId;

    @Schema(description = "租户编号")
    private Long tenantId;
}
