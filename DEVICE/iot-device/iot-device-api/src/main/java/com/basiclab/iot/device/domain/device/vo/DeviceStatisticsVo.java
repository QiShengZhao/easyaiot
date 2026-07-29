package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class DeviceStatisticsVo {

    /**
     * 设备总数
     */
    @Schema(description = "设备总数")
    private Integer deviceTotal;
    /**
     * 普通设备数量
     */
    @Schema(description = "普通设备数量")
    private Integer commonDeviceAmount;

    /**
     * 网关设备数量
     */
    @Schema(description = "网关设备数量")
    private Integer gatewayDeviceAmount;

    /**
     * 子设备数量
     */
    @Schema(description = "子设备数量")
    private Integer subsetDeviceAmount;
}
