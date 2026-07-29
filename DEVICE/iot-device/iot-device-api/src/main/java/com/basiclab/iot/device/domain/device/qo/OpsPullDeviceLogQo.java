package com.basiclab.iot.device.domain.device.qo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-06-03
 */
@Data
@ToString
@Schema(description = "下发拉取设备日志指令接口参数模型")
public class OpsPullDeviceLogQo implements Serializable {

    private static final long serialVersionUID = 5951462969462211980L;

    @Schema(description = "设备唯一ID")
    private String deviceIdentification;

    @Schema(description = "区间时长(eventTime前多少时长的日志)，单位分钟")
    private Integer interval;

    @Schema(description = "日志模式(扩展参数)")
    private String model;

}
