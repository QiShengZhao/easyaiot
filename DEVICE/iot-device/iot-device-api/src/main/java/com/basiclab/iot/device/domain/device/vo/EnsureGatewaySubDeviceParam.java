package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 网关代报时确保子设备存在（自动创建 / 补齐绑定）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Schema(description = "网关确保子设备存在参数")
public class EnsureGatewaySubDeviceParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "网关设备标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "网关设备标识不能为空")
    private String gatewayIdentification;

    @Schema(description = "子设备所属产品标识（须为 SUBSET 产品）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "子设备产品标识不能为空")
    private String productIdentification;

    @Schema(description = "子设备标识", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "子设备标识不能为空")
    private String deviceIdentification;

    @Schema(description = "子设备名称（新建时可选）")
    private String deviceName;

    @Schema(description = "租户编号")
    private Long tenantId;
}
