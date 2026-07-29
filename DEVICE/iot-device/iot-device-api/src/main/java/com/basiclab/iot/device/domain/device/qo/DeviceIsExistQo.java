package com.basiclab.iot.device.domain.device.qo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * DeviceIsExistQo
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */

@Data
@Schema(description = "DmDeviceIsExistQo对象")
public class DeviceIsExistQo implements Serializable {

    private static final long serialVersionUID = -2247287287146748962L;
    /**
     * 设备did
     */
    @Schema(description = "设备唯一ID")
    private String deviceIdentification;
    /**
     * 设备sn
     */
    @Schema(description = "设备SN")
    private String deviceSn;
}