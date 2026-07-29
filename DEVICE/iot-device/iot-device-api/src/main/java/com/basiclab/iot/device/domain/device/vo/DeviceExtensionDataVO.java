package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 设备扩展数据响应VO
 * 
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Schema(description = "设备扩展数据响应")
@Data
public class DeviceExtensionDataVO implements Serializable {
    
    /**
     * 设备ID
     */
    @Schema(description = "设备ID")
    private Long deviceId;
    
    /**
     * 设备标识
     */
    @Schema(description = "设备标识")
    private String deviceIdentification;
    
    /**
     * 扩展信息类型
     */
    @Schema(description = "扩展信息类型")
    private String extensionType;
    
    /**
     * 扩展数据（JSON格式）
     */
    @Schema(description = "扩展数据（JSON格式）")
    private Object extensionData;
    
    /**
     * 最后更新时间
     */
    @Schema(description = "最后更新时间")
    private LocalDateTime updateTime;
}

