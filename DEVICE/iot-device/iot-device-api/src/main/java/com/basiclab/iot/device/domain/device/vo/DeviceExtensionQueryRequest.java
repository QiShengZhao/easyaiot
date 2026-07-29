package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 设备扩展信息查询请求
 * 
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Schema(description = "设备扩展信息查询请求")
@Data
@Validated
public class DeviceExtensionQueryRequest {
    
    /**
     * 设备ID
     */
    @Schema(description = "设备ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "设备ID不能为空")
    private Long deviceId;
    
    /**
     * 扩展信息类型
     * properties: 属性数据
     * events: 事件数据
     * serviceResponse: 服务响应数据
     * desired: 期望值数据
     * shadow: 影子数据
     * tags: 标签数据
     * otaQuery: OTA查询数据
     */
    @Schema(description = "扩展信息类型（properties/events/serviceResponse/desired/shadow/tags/otaQuery）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "扩展信息类型不能为空")
    private String extensionType;
}

