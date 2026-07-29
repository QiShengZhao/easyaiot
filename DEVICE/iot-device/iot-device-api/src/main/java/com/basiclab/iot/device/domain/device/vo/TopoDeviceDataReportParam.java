package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 设备数据上报数据模型
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @CreateDate: 2024/4/25$ 12:52$
 * @UpdateDate: 2024/4/25$ 12:52$
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode
@Builder
@Schema(description = "设备数据上报数据模型")
public class TopoDeviceDataReportParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备数据（设备数据）")
    @NotNull(message = "设备数据不能为空")
    private List<DeviceS> devices;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Accessors(chain = true)
    @Schema(description = "设备数据模型")
    public static class DeviceS implements Serializable {
        private static final long serialVersionUID = 1L;

        @Schema(description = "设备唯一标识（平台生成的设备唯一标识）")
        @NotEmpty(message = "设备唯一标识不能为空")
        private String deviceId;

        @Schema(description = "服务列表（服务列表）")
        @NotNull(message = "服务列表不能为空")
        private List<Services> services;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        @Accessors(chain = true)
        @Schema(description = "服务数据模型")
        public static class Services implements Serializable {
            private static final long serialVersionUID = 1L;

            @Schema(description = "服务编码（服务编码，对应平台产品服务编码）")
            @NotEmpty(message = "服务编码不能为空")
            private String serviceCode;

            @Schema(description = "服务数据（服务数据，不固定内容）")
            @NotNull(message = "服务数据不能为空")
            private Object data;

            @Schema(description = "事件时间（时间格式：13位毫秒时间戳。例如，1622552643000表示2021年6月1日17时24分3秒（UTC时间）。）")
            @NotEmpty(message = "事件时间不能为空")
            private Long eventTime;
        }
    }
}
