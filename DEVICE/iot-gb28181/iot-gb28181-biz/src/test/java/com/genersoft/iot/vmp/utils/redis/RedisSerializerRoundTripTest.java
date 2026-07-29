package com.genersoft.iot.vmp.utils.redis;

import com.alibaba.fastjson2.support.spring6.data.redis.GenericFastJsonRedisSerializer;
import com.genersoft.iot.vmp.gb28181.bean.Device;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * GB28181 模块 Redis 序列化器的往返（round-trip）测试
 *
 * 背景：RedisTemplateConfig 使用 fastjson2 的 GenericFastJsonRedisSerializer 存储设备/通道等缓存。
 * Boot 3 升级需将 fastjson2-extension-spring5 换为 spring6，本测试锁定序列化格式行为，
 * 升级后若往返或 @type 类型标记行为变化（导致存量缓存不可读），此测试会失败报警。
 */
public class RedisSerializerRoundTripTest {

    private final GenericFastJsonRedisSerializer genericSerializer = new GenericFastJsonRedisSerializer();

    @Test
    public void testGenericSerializer_deviceRoundTrip() {
        Device device = new Device();
        device.setDeviceId("34020000001320000001");
        device.setName("测试摄像头-大门");
        device.setOnLine(true);

        byte[] bytes = genericSerializer.serialize(device);
        assertNotNull(bytes);

        Object restored = genericSerializer.deserialize(bytes);
        Device restoredDevice = assertInstanceOf(Device.class, restored,
                "反序列化必须还原为 Device 类型（依赖 @type 类型标记）");
        assertEquals("34020000001320000001", restoredDevice.getDeviceId());
        assertEquals("测试摄像头-大门", restoredDevice.getName());
        assertTrue(restoredDevice.isOnLine());
    }

    @Test
    public void testGenericSerializer_typeMarkerPresent() {
        // 存量缓存兼容性依赖 @type 标记：升级 fastjson2 扩展后此行为必须保持
        Device device = new Device();
        device.setDeviceId("34020000001320000001");
        String json = new String(genericSerializer.serialize(device));
        assertTrue(json.contains("@type"), "序列化结果应包含 @type 类型标记，实际：" + json);
    }

    @Test
    public void testGenericSerializer_mapRoundTrip() {
        Map<String, Object> value = new HashMap<>();
        value.put("count", 3);
        value.put("stream", "34020000001320000001_34020000001320000002");

        Object restored = genericSerializer.deserialize(genericSerializer.serialize(value));
        assertInstanceOf(Map.class, restored);
        assertEquals("34020000001320000001_34020000001320000002", ((Map<?, ?>) restored).get("stream"));
    }

    @Test
    public void testGenericSerializer_nullSafety() {
        assertNull(genericSerializer.deserialize(null));
        assertNull(genericSerializer.deserialize(new byte[0]));
    }

    @Test
    public void testTypedSerializer_roundTrip() {
        FastJsonRedisSerializer<Device> typedSerializer = new FastJsonRedisSerializer<>(Device.class);
        Device device = new Device();
        device.setDeviceId("34020000001320000001");
        device.setManufacturer("TestVendor");

        Device restored = typedSerializer.deserialize(typedSerializer.serialize(device));
        assertNotNull(restored);
        assertEquals("34020000001320000001", restored.getDeviceId());
        assertEquals("TestVendor", restored.getManufacturer());
    }
}
