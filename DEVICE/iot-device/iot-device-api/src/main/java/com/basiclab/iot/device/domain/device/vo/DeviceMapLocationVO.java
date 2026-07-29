package com.basiclab.iot.device.domain.device.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 设备地图分布点位（轻量字段）
 */
@Schema(description = "设备地图分布点位")
@Data
public class DeviceMapLocationVO implements Serializable {

    @Schema(description = "设备主键")
    private Long id;

    @Schema(description = "设备标识")
    private String deviceIdentification;

    @Schema(description = "设备名称")
    private String deviceName;

    @Schema(description = "连接状态 ONLINE/OFFLINE/INIT")
    private String connectStatus;

    @Schema(description = "是否在线")
    private Boolean online;

    @Schema(description = "设备类型")
    private String deviceType;

    @Schema(description = "产品标识")
    private String productIdentification;

    @Schema(description = "经度")
    private BigDecimal longitude;

    @Schema(description = "纬度")
    private BigDecimal latitude;

    @Schema(description = "位置名称/地址")
    private String address;

    @Schema(description = "是否已配置坐标")
    private Boolean hasLocation;

    @Schema(description = "位置更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime locationUpdatedAt;

    private static final long serialVersionUID = 1L;
}
