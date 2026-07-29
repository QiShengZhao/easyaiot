package com.basiclab.iot.device.domain.device.qo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * DeviceAlarmQo
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */

@Data
@Schema(description = "DeviceAlarmQo对象")
public class DeviceAlarmQo implements Serializable {

    private static final long serialVersionUID = -2247287287146748992L;
    /**
     * 应用名
     */
    @Schema(description = "应用名")
    private String app;
    /**
     * 流id
     */
    @Schema(description = "流id")
    private String stream;
    /**
     * 桶名称
     */
    @Schema(description = "桶名称")
    private String bucketName;
    /**
     * 对象前缀
     */
    @Schema(description = "对象前缀")
    private String prefix;
    /**
     * 对象key
     */
    @Schema(description = "对象key")
    private String objectKey;
    /**
     * 告警内容
     */
    @Schema(description = "告警内容")
    private String content;
    /**
     * 告警时间
     */
    @Schema(description = "告警时间")
    private String timestamp;
}