package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "设备健康评分")
@Data
public class DeviceHealthScoreVO implements Serializable {

    @Schema(description = "健康分 0-100")
    private Integer score;

    @Schema(description = "健康等级 GOOD/WARNING/RISK")
    private String level;

    @Schema(description = "在线可用性权重占比说明")
    private String onlineWeightDesc;

    @Schema(description = "阈值风险权重占比说明")
    private String thresholdWeightDesc;

    private Integer onlineScore;
    private Integer thresholdScore;

    private Integer totalDevices = 1;
    private Integer onlineCount = 0;
    private Integer offlineCount = 0;

    private Integer openAlarmCount = 0;
    private Integer thresholdConfiguredCount = 0;
    private Integer thresholdBreachedCount = 0;

    private List<String> reasons = new ArrayList<>();
}
