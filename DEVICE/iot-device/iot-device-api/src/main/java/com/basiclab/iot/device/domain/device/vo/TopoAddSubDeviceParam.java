package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 网关设备添加子设备数据模型
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @CreateDate: 2024/4/25$ 12:52$
 * @UpdateDate: 2024/4/25$ 12:52$
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode
@Builder
@Schema(description = "网关设备添加子设备数据模型")
public class TopoAddSubDeviceParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "网关设备标识（网关设备自身的唯一标识）")
    @NotEmpty(message = "网关设备标识不能为空")
    private String gatewayIdentification;

    @Schema(description = "子设备信息集合（子设备信息集合）")
    @NotNull(message = "子设备信息集合不能为空")
    private List<DeviceInfos> deviceInfos;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DeviceInfos {

        @Schema(description = "子设备ID（子设备自身的唯一标识）")
        private String nodeId;

        @Schema(description = "子设备名称（子设备名称）")
        private String name;

        @Schema(description = "子设备描述（子设备描述）")
        private String description;

        @Schema(description = "子设备厂商ID（子设备厂商ID）")
        private String manufacturerId;

        @Schema(description = "子设备型号（子设备型号）")
        private String model;
    }
}
