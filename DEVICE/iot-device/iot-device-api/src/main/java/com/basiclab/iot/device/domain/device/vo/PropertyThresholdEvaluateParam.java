package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 属性上报后阈值评估请求
 */
@Schema(description = "属性阈值评估请求")
@Data
public class PropertyThresholdEvaluateParam implements Serializable {

    @Schema(description = "设备标识")
    private String deviceIdentification;

    @Schema(description = "设备名称")
    private String deviceName;

    @Schema(description = "属性键值，key=propertyCode, description=上报值")
    private Map<String, Object> properties;
}
