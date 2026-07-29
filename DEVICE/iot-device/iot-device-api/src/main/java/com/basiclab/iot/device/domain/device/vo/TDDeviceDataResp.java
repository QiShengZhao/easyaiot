package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class TDDeviceDataResp {
    /**
     * 时间
     */
    @Schema(description = "时间")
    private long ts;
    /**
     * 标识符
     */
    @Schema(description = "标识符")
    private String propertyCode;
    /**
     * 属性名称
     */
    @Schema(description = "属性名称")
    private String propertyName;
    /**
     * 数据类型
      */
    @Schema(description = "数据类型")
    private String datatype;
    /**
     * 数据
     */
    @Schema(description = "数据")
    private String dataValue;

    /**
     * 工业协议采集时保存的原始响应数据段。
     */
    @Schema(description = "原始响应数据")
    private String rawData;

    /**
     * 指示单位。支持长度不超过50。
     取值根据参数确定，如：
     •温度单位：“C”或“K”
     •百分比单位：“%”
     •压强单位：“Pa”或“kPa”
     */
    @Schema(description="指示单位。支持长度不超过50。,取值根据参数确定，如：,•温度单位：“C”或“K”,•百分比单位：“%”,•压强单位：“Pa”或“kPa”,")
    private String unit;

}
