package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class DeviceDetail {

    @Schema(description = "设备信息")
    private DeviceParams device;

    @Schema(description = "产品信息")
    private Product product;
}
