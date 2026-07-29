package com.basiclab.iot.tdengine.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Tdengine中的device_data表
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class DeviceData {
    /**
     * 设备标识
     */
    @Schema(description = "设备标识")
    private String deviceIdentification;
    /**
     * 时间
     */
    @Schema(description = "时间")
    private long lastUpdateTime;

    @Schema(description = "方法类型 properties:属性 service:服务 event:事件")
    private String functionType;
    /**
     * 标识符
     */
    @Schema(description = "标识符")
    private String identifier;
    /**
     * 数据类型
      */
    @Schema(description = "数据类型")
    private String dataType;
    /**
     * 数据
     */
    @Schema(description = "数据")
    private String dataValue;

}
