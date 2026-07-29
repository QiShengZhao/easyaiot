package com.basiclab.iot.device.domain.device.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DeviceServiceInvokeResponse
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class DeviceServiceInvokeResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    private Long id;

    /**
     * 消息编号（来自IotDeviceMessage.id）
     */
    @Schema(description = "消息编号")
    private String messageId;

    /**
     * 设备编号
     */
    @Schema(description = "设备编号")
    private Long deviceId;

    /**
     * 设备标识
     */
    @Schema(description = "设备标识")
    private String deviceIdentification;

    /**
     * 产品标识
     */
    @Schema(description = "产品标识")
    private String productIdentification;

    /**
     * 服务标识（从topic中提取的identifier）
     */
    @Schema(description = "服务标识")
    private String serviceIdentifier;

    /**
     * 请求编号（来自IotDeviceMessage.requestId）
     */
    @Schema(description = "请求编号")
    private String requestId;

    /**
     * 请求方法（来自IotDeviceMessage.method，通常是thing.service.invoke）
     */
    @Schema(description = "请求方法")
    private String method;

    /**
     * 响应数据（来自IotDeviceMessage.data，JSON格式）
     */
    @Schema(description = "响应数据")
    private String responseData;

    /**
     * 响应错误码（来自IotDeviceMessage.code）
     */
    @Schema(description = "响应错误码")
    private Integer responseCode;

    /**
     * 响应消息（来自IotDeviceMessage.msg）
     */
    @Schema(description = "响应消息")
    private String responseMsg;

    /**
     * MQTT Topic
     */
    @Schema(description = "MQTT Topic")
    private String topic;

    /**
     * 上报时间（来自IotDeviceMessage.reportTime）
     */
    @Schema(description = "上报时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reportTime;

    /**
     * 租户编号
     */
    @Schema(description = "租户编号")
    private Long tenantId;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}

