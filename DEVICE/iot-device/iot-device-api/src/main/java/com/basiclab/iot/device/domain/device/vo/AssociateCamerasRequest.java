package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 关联流媒体摄像头请求
 */
@Data
public class AssociateCamerasRequest {

    @Schema(description = "IoT设备主键")
    private Long iotDeviceId;

    @Schema(description = "流媒体摄像头ID列表")
    private List<String> cameraDeviceIds;
}
