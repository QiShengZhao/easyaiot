package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * ExtendInfoVo
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode
@Builder
@Schema(description = "扩展信息vo")
public class ExtendInfoVo {

    @Schema(description = "事件类型(PUBLISH:事件发布)")
    private String event;

    @Schema(description = "协议类型(MQTT : MQTT协议; MODBUS : MODBUS协议)")
    private String protocol;

    @Schema(description = "发送主题")
    private String topic;

    @Schema(description = "mqtt的qos")
    private String qos;

    @Schema(description = "消息发送时间")
    private String time;

    @Schema(description = "指令名称")
    private String commandName;

}
