package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;

/**
 * -----------------------------------------------------------------------------
 * File Name: PublishMessageRequestParam
 * -----------------------------------------------------------------------------
 * Description:
 * 发布消息
 * -----------------------------------------------------------------------------
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @version 1.0
 * -----------------------------------------------------------------------------
 * Revision History:
 * Date         Author          Version     Description
 * --------      --------     -------   --------------------
 * 2024/4/17       basiclab        1.0        Initial creation
 * -----------------------------------------------------------------------------
 * @email
 * @date 2025/4/17 19:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Schema(description = "Parameters required for publishing a message via MQTT.")
public class PublishMessageRequestParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "MQTT topic to which the message will be published.（This is the topic path under which the message will be categorized.）")
    @NotEmpty(message = "MQTT topic cannot be empty")
    private String topic;

    @Schema(description = "Quality of Service for the MQTT message.（0 = At most once, 1 = At least once, 2 = Exactly once.）")
    @NotEmpty(message = "QoS cannot be empty")
    private String qos;

    @Schema(description = "The actual message payload to be sent.（This payload could be any format as required by the application, encoded appropriately.）")
    @NotNull(message = "Message payload cannot be null")
    private String payload;

    @Schema(description = "Tenant ID associated with the message, for multi-tenant environments.（Unique identifier for the tenant.）", name = "tenantId ,default value is iot")
    @NotEmpty(message = "Tenant ID cannot be empty")
    private String tenantId;

    @Schema(description = "Expiry seconds for the message.（Duration in seconds after which the message should expire.）")
    private String expirySeconds;

    @Schema(description = "Additional metadata associated with the message.（Optional metadata to accompany the message.）")
    private Map<String, String> metadata;
}
