package com.basiclab.iot.device.domain.device.oo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-06-03
 */
@Data
@Schema(description = "设备上报Oo")
public class DeviceReportOo implements Serializable {
    /**
     * 客户端标识
     */
    @Schema(description = "客户端标识")
    private String clientId;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String userName;

    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;

    /**
     * 应用ID
     */
    @Schema(description = "应用ID")
    private String appId;

    /**
     * 认证方式
     */
    @Schema(description = "认证方式")
    private String authMode;

    /**
     * 设备标识
     */
    @Schema(description = "设备标识")
    private String deviceIdentification;

    /**
     * 设备名称
     */
    @Schema(description = "设备名称")
    private String deviceName;

    /**
     * 连接实例
     */
    @Schema(description = "连接实例")
    private String connector;

    /**
     * 设备描述
     */
    @Schema(description = "设备描述")
    private String deviceDescription;

    /**
     * 设备状态： 启用 || 禁用
     */
    @Schema(description = "设备状态： 启用 || 禁用")
    private String deviceStatus;

    /**
     * 连接状态 : 在线：ONLINE || 离线：OFFLINE || 未连接：INIT
     */
    @Schema(description = "连接状态 : 在线：ONLINE || 离线：OFFLINE || 未连接：INIT,")
    private String connectStatus;

    /**
     * 是否遗言
     */
    @Schema(description = "是否遗言")
    private String isWill;

    /**
     * 设备标签
     */
    @Schema(description = "设备标签")
    private String deviceTags;


    /**
     * 协议类型 ：mqtt || coap || modbus || http
     */
    @Schema(description = "协议类型 ：mqtt || coap || modbus || http")
    private String protocolType;

    /**
     * 设备类型
     */
    @Schema(description = "设备类型")
    private String deviceType;

    /**
     * 加密密钥
     */
    @Schema(description = "加密密钥")
    private String encryptKey;
    /**
     * 加密向量
     */
    @Schema(description = "加密向量")
    private String encryptVector;
    /**
     * 签名密钥
     */
    @Schema(description = "签名密钥")
    private String signKey;
    /**
     * 传输协议的加密方式：0-明文传输、1-SM4、2-AES
     */
    @Schema(description = "传输协议的加密方式：0-明文传输、1-SM4、2-AES ")
    private String encryptMethod;

    /**
     * 软件版本
     */
    @Schema(description = "软件版本")
    private String swVersion;
    /**
     * 设备版本
     */
    @Schema(description = "设备版本")
    private String fwVersion;
    /**
     * sdk版本
     */
    @Schema(description = "sdk版本（如v1,v2,v3等）", example = "v1")
    private String deviceSdkVersion;

    /**
     * 设备版本
     */
    @Schema(description = "设备版本")
    private String deviceVersion;

    /**
     * 设备sn号
     */
    @Schema(description = "设备sn号")
    private String deviceSn;

    /**
     * ip地址
     */
    @Schema(description = "ip地址")
    private String ipAddress;

    /**
     * mac地址
     */
    @Schema(description = "mac地址")
    private String macAddress;


    /**
     * 激活状态
     */
    @Schema(description = "激活状态")
    private String activeStatus;


    /**
     * 扩展json
     */
    @Schema(description = "扩展json")
    private String extendJson;

    /**
     * 激活时间
     */
    @Schema(description = "激活时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime activatedTime;

    /**
     * 最后上线时间
     */
    @Schema(description = "最后上线时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastOnlineTime;

}
