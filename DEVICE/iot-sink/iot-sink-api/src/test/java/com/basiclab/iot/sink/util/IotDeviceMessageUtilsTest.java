package com.basiclab.iot.sink.util;

import com.basiclab.iot.sink.enums.IotDeviceMessageMethodEnum;
import com.basiclab.iot.sink.mq.message.IotDeviceMessage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link IotDeviceMessageUtils} 的单元测试
 *
 * 覆盖设备接入关键路径：设备 ID 解析、上/下行消息判定、属性值提取、消息总线 Topic 构建
 */
public class IotDeviceMessageUtilsTest {

    // ========== parseLongDeviceIdOrNull ==========

    @Test
    public void testParseLongDeviceId_numeric() {
        assertEquals(123456L, IotDeviceMessageUtils.parseLongDeviceIdOrNull("123456"));
        assertEquals(123L, IotDeviceMessageUtils.parseLongDeviceIdOrNull(" 123 "));
    }

    @Test
    public void testParseLongDeviceId_gb28181CompositeIdReturnsNull() {
        // GB28181 等复合 ID 不是纯数字，应返回 null 而不是抛异常
        assertNull(IotDeviceMessageUtils.parseLongDeviceIdOrNull("34020000001320000001@ch1"));
        assertNull(IotDeviceMessageUtils.parseLongDeviceIdOrNull(""));
        assertNull(IotDeviceMessageUtils.parseLongDeviceIdOrNull(null));
    }

    // ========== generateMessageId ==========

    @Test
    public void testGenerateMessageId_uniqueAndNonBlank() {
        String id1 = IotDeviceMessageUtils.generateMessageId();
        String id2 = IotDeviceMessageUtils.generateMessageId();
        assertNotNull(id1);
        assertFalse(id1.isEmpty());
        assertNotEquals(id1, id2);
    }

    // ========== isUpstreamMessage / isReplyMessage ==========

    @Test
    public void testIsUpstream_propertyPost() {
        // 属性上报：设备 -> 平台，非回复时为上行
        IotDeviceMessage msg = IotDeviceMessage.builder()
                .method(IotDeviceMessageMethodEnum.PROPERTY_POST.getMethod()).build();
        assertTrue(IotDeviceMessageUtils.isUpstreamMessage(msg));
        assertFalse(IotDeviceMessageUtils.isReplyMessage(msg));
    }

    @Test
    public void testIsUpstream_propertySetReply() {
        // 属性设置(下行)的回复：方向取反，变为上行
        IotDeviceMessage msg = IotDeviceMessage.builder()
                .method(IotDeviceMessageMethodEnum.PROPERTY_SET.getMethod())
                .code(0).build();
        assertTrue(IotDeviceMessageUtils.isReplyMessage(msg));
        assertTrue(IotDeviceMessageUtils.isUpstreamMessage(msg));
    }

    @Test
    public void testIsUpstream_serviceInvokeDownstream() {
        IotDeviceMessage msg = IotDeviceMessage.builder()
                .method(IotDeviceMessageMethodEnum.SERVICE_INVOKE.getMethod()).build();
        assertFalse(IotDeviceMessageUtils.isUpstreamMessage(msg));
    }

    // ========== getIdentifier / extractPropertyValue ==========

    @Test
    public void testGetIdentifier_eventPost() {
        Map<String, Object> params = new HashMap<>();
        params.put("identifier", "temperature_alarm");
        IotDeviceMessage msg = IotDeviceMessage.builder()
                .method(IotDeviceMessageMethodEnum.EVENT_POST.getMethod())
                .params(params).build();
        assertEquals("temperature_alarm", IotDeviceMessageUtils.getIdentifier(msg));
    }

    @Test
    public void testExtractPropertyValue_directIdentifierField() {
        Map<String, Object> params = new HashMap<>();
        params.put("temperature", 25.5);
        IotDeviceMessage msg = IotDeviceMessage.builder()
                .method(IotDeviceMessageMethodEnum.PROPERTY_POST.getMethod())
                .params(params).build();
        assertEquals(25.5, IotDeviceMessageUtils.extractPropertyValue(msg, "temperature"));
    }

    @Test
    public void testExtractPropertyValue_propertiesStructure() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("humidity", 60);
        Map<String, Object> params = new HashMap<>();
        params.put("properties", properties);
        IotDeviceMessage msg = IotDeviceMessage.builder()
                .method(IotDeviceMessageMethodEnum.PROPERTY_POST.getMethod())
                .params(params).build();
        assertEquals(60, IotDeviceMessageUtils.extractPropertyValue(msg, "humidity"));
    }

    @Test
    public void testExtractPropertyValue_notFound() {
        IotDeviceMessage msg = IotDeviceMessage.builder()
                .method(IotDeviceMessageMethodEnum.PROPERTY_POST.getMethod())
                .params(new HashMap<>()).build();
        assertNull(IotDeviceMessageUtils.extractPropertyValue(msg, "nonexistent"));
    }

    // ========== Topic 构建 ==========

    @Test
    public void testBuildMessageBusGatewayDeviceMessageTopic() {
        assertEquals("iot_device_message_192_168_1_1_8080",
                IotDeviceMessageUtils.buildMessageBusGatewayDeviceMessageTopic("192_168_1_1_8080"));
    }

    @Test
    public void testGenerateServerId_noDots() {
        // RocketMQ 等场景 Topic 不允许 . 符号
        String serverId = IotDeviceMessageUtils.generateServerId(8080);
        assertFalse(serverId.contains("."), "serverId 不应包含 . 符号：" + serverId);
        assertTrue(serverId.endsWith("_8080"));
    }
}
