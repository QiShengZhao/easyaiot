package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "属性预测诊断结果")
@Data
public class PropertyPredictResultVO implements Serializable {

    private String deviceIdentification;
    private String propertyCode;
    private String propertyName;
    private String unit;

    @Schema(description = "有效样本数")
    private Integer sampleCount;

    @Schema(description = "最少需要样本数")
    private Integer minSampleRequired = 6;

    @Schema(description = "是否可预测")
    private Boolean predictReady;

    private String message;

    private Double latestValue;
    private Long latestTs;
    private String deviceStatus;

    @Schema(description = "单位时间趋势（每小时）")
    private Double hourlyTrend;

    @Schema(description = "综合故障风险 0-100")
    private Integer failureRisk;

    @Schema(description = "风险等级 LOW/MEDIUM/HIGH")
    private String riskLevel;

    @Schema(description = "风险说明")
    private String riskMessage;

    private Double anomalyRatio;
    private Double sensitivity;
    private String anomalyMessage;

    private String failureMessage;
    private String degradationMessage;
    private Double degradationDegree;
    private Double windowChange;
    private String runStateMessage;

    private Double compressionRisk;
    private Long predictEndTs;

    private List<PredictPoint> history = new ArrayList<>();
    private List<PredictPoint> prediction = new ArrayList<>();
    private List<PredictPoint> upperBound = new ArrayList<>();
    private List<PredictPoint> lowerBound = new ArrayList<>();

    @Data
    public static class PredictPoint implements Serializable {
        private Long ts;
        private Double value;
    }
}
