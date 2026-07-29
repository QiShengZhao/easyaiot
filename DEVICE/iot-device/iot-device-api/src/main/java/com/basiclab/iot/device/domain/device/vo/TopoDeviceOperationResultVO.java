package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @program: EasyAIoT
 * @description: 设备操作结果数据模型
 * @packagename: com.basiclab.iot.device.vo.result
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @date: 2023-05-22 14:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Schema(description = "设备操作结果数据ResultVO")
public class TopoDeviceOperationResultVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "请求处理的结果码（“0”表示成功。非“0”表示失败。详见附录。）")
    private Integer statusCode;

    @Schema(description = "响应状态描述（响应状态描述）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String statusDesc;

    @Schema(description = "操作结果信息（操作结果信息）")
    private List<OperationRsp> data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Accessors(chain = true)
    @Schema(description = "操作结果结果数据模型")
    public static class OperationRsp implements Serializable {
        private static final long serialVersionUID = 1L;

        @Schema(description = "设备ID（设备ID，平台生成的设备唯一标识）")
        private String deviceId;

        @Schema(description = "请求处理的结果码（“0”表示成功。非“0”表示失败。详见附录。）")
        private Integer statusCode;

        @Schema(description = "响应状态描述（响应状态描述）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        private String statusDesc;
    }
}