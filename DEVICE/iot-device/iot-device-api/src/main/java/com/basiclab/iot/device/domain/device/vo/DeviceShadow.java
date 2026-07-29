package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class DeviceShadow {

    /**
     * 期望值
     */
    @Schema(description = "期望值")
    private List<DeviceShadowCommand> desired;
    /**
     * 实际值
     */
    @Schema(description = "实际值")
    private List<TDDeviceDataResp> actual;

}
