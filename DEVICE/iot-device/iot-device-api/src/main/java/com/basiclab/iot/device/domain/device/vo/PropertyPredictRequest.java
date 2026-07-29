package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "属性预测诊断请求")
@Data
public class PropertyPredictRequest implements Serializable {

    @Schema(description = "设备标识")
    private String deviceIdentification;

    @Schema(description = "属性标识")
    private String propertyCode;

    @Schema(description = "属性名称")
    private String propertyName;

    @Schema(description = "开始时间 epoch ms")
    private Long startTime;

    @Schema(description = "结束时间 epoch ms")
    private Long endTime;

    @Schema(description = "预测未来点数，默认 12")
    private Integer predictPoints;

    @Schema(description = "单位")
    private String unit;
}
