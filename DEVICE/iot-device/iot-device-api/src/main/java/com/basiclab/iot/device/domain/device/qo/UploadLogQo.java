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
 * @created 2025-06-25
 */
@Data
@ToString
@Schema(description = "下发上报日志指令")
public class UploadLogQo implements Serializable {

    private static final long serialVersionUID = -5370284608661162149L;

    @Schema(description = "deviceIdentification（设备的唯一标识）")
    private String deviceIdentification;

    @Schema(description = "版本号（同一个指令版本号保持一致）")
    private String version;

    @Schema(description = "指令类型（1:上传日志，2:日志上报存储成功，3:日志上报失败）")
    private String type;

    @Schema(description = "时长（区间时长(eventTime前多少时长的日志)，单位分钟）")
    private String interval;

    @Schema(description = "模式（日志模式，扩展参数）")
    private String model;
}
