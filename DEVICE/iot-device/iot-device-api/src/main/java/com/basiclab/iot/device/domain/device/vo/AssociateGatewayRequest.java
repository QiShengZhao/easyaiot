package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class AssociateGatewayRequest {
    /**
     * 设备id列表
     */
    @Schema(description = "设备id列表")
    private List<Long> idList;
    /**
     * 目标网关设备标识
     */
    @Schema(description = "目标网关设备标识")
    private String targetDeviceIdentification;
}