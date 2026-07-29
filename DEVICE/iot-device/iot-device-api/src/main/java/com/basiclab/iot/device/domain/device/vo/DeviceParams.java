package com.basiclab.iot.device.domain.device.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.basiclab.iot.common.annotation.Excel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: Device Entity class model
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @CreateDate: 2024/5/4$ 18:57$
 * @UpdateDate: 2024/5/4$ 18:57$
 * @Version: V1.0
 */
@Data
public class DeviceParams implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Excel(name = "id", cellType = Excel.ColumnType.NUMERIC, prompt = "id")
    @Schema(description = "id", hidden = true)
    private Long id;

    /**
     * 客户端标识
     */
    @Excel(name = "客户端标识")
    @Schema(description = "客户端标识")
    private String clientId;

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    @Schema(description = "应用ID")
    private String appId;

    /**
     * 设备标识
     */
    @Excel(name = "设备标识")
    @Schema(description = "设备标识")
    private String deviceIdentification;

    /**
     * 设备名称
     */
    @Excel(name = "设备名称")
    @Schema(description = "设备名称")
    private String deviceName;

    /**
     * 设备描述
     */
    @Excel(name = "设备描述")
    @Schema(description = "设备描述")
    private String deviceDescription;

    /**
     * 设备状态： 启用 || 禁用
     */
    @Excel(name = "设备状态")
    @Schema(description = "设备状态： 启用 || 禁用")
    private String deviceStatus;

    /**
     * 连接状态 : 在线：ONLINE || 离线：OFFLINE || 未连接：INIT
     */
    @Excel(name = "连接状态")
    @Schema(description = "连接状态 : 在线：ONLINE || 离线：OFFLINE || 未连接：INIT,")
    private String connectStatus;

    /**
     * 是否遗言
     */
    @Excel(name = "是否遗言")
    @Schema(description = "是否遗言")
    private String isWill;

    /**
     * 产品标识
     */
    @Excel(name = "产品标识")
    @Schema(description = "产品标识")
    private String productIdentification;

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
     * ip地址
     */
    @Excel(name = "ip地址")
    @Schema(description = "ip地址")
    private String ipAddress;

    /**
     * 激活时间
     */
    @Excel(name = "激活时间")
    @Schema(description = "激活时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime activatedTime;

    /**
     * 最后上线时间
     */
    @Excel(name = "最后上线时间")
    @Schema(description = "最后上线时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastOnlineTime;

    /**
     * mac地址
     */
    @Excel(name = "mac地址")
    @Schema(description = "mac地址")
    private String macAddress;

    /**
     * 激活状态
     */
    @Excel(name = "激活状态")
    @Schema(description = "激活状态")
    private Integer activeStatus;

    /**
     * 扩展Json
     */
    @Excel(name = "扩展Json")
    @Schema(description = "扩展Json")
    private String extension;

    /**
     * 备注
     */
    @Excel(name = "备注")
    @Schema(description = "备注")
    private String remark;

    /**
     * 设备类型
     */
    @Excel(name = "设备类型")
    @Schema(description = "设备类型")
    private String deviceType;

    /**
     * 父设备标识（网关子设备）
     */
    @Excel(name = "父设备标识")
    @Schema(description = "父设备标识")
    private String parentIdentification;

    /**
     * 设备位置信息
     */
    @Schema(description = "设备位置信息")
    private DeviceLocation deviceLocation;


}
