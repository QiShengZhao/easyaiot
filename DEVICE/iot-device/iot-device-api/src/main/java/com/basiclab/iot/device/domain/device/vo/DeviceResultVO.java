package com.basiclab.iot.device.domain.device.vo;

import cn.hutool.core.map.MapUtil;
import com.basiclab.iot.common.annotation.Excel;
import com.basiclab.iot.device.domain.product.vo.result.ProductResultVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 表单查询方法返回值VO
 * 设备档案信息表
 * </p>
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @date 2023-03-14 19:39:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@Schema(description = "设备档案信息表")
public class DeviceResultVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> echoMap = MapUtil.newHashMap();

    /**
     * id
     */
    @Schema(description = "id")
    private Long id;

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
     * 产品标识
     */
    @Schema(description = "产品标识")
    private String productIdentification;


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
    private String encryptMethod = "0";

    /**
     * 设备版本
     */
    @Excel(name = "设备版本")
    @Schema(description = "设备版本")
    private String deviceVersion;

    /**
     * 设备sn号
     */
    @Excel(name = "设备sn号")
    @Schema(description = "设备sn号")
    private String deviceSn;

    /**
     * 设备产品基础信息
     */
    @Schema(description = "设备产品基础信息")
    private ProductResultVO productResultVO;

}
