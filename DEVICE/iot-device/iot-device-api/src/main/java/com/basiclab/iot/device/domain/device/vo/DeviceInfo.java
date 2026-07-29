package com.basiclab.iot.device.domain.device.vo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* @Description: 子设备档案表
* @author 翱翔的雄库鲁
* @email andywebjava@163.com
* @wechat EasyAIoT2025
* @E-mail: andywebjava@163.com
* @Website: https://gitee.com/soaring-xiongkulu/easyaiot
* @CreateDate: 2024/4/25$ 12:48$
* @UpdateDate: 2024/4/25$ 12:48$
* @UpdateRemark: 修改内容
* @Version: V1.0
*/
@Schema(description="子设备档案表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@Builder
@TableName("device_info")
public class DeviceInfo implements Serializable {
    /**
    * 主键
    */
    @Schema(description="主键")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
    * 边设备主键
    */
    @Schema(description="边设备主键")
    private Long deviceIdentification;

    /**
     * 边设备唯一标识
     */
    @Schema(description="边设备唯一标识")
    private String edgeDevicesIdentification;

    /**
    * 应用ID
    */
    @Schema(description="应用ID")
    private String appId;

    /**
    * 设备节点ID
    */
    @Schema(description="设备节点ID")
    private String nodeId;

    /**
    * 设备名称
    */
    @Schema(description="设备名称")
    private String nodeName;

    /**
    * 子设备唯一标识
    */
    @Schema(description="子设备唯一标识")
    private String deviceId;

    /**
    * 设备描述
    */
    @Schema(description="设备描述")
    private String description;

    /**
    * 厂商ID
    */
    @Schema(description="厂商ID")
    private String manufacturerId;

    /**
    * 设备型号
    */
    @Schema(description="设备型号")
    private String model;

    /**
    * 子设备连接状态 : 在线：ONLINE || 离线：OFFLINE || 未连接：INIT
    */
    @Schema(description="子设备连接状态 : 在线：ONLINE || 离线：OFFLINE || 未连接：INIT")
    private String connectStatus;

    /**
    * 是否支持设备影子TRUE:1、FALSE :0
    */
    @Schema(description="是否支持设备影子TRUE:1、FALSE :0")
    private Boolean shadowEnable;

    /**
    * 设备影子数据表名
    */
    @Schema(description="设备影子数据表名")
    private String shadowTableName;

    /**
    * 状态(字典值：0启用  1停用)
    */
    @Schema(description="状态(字典值：0启用  1停用)")
    private String status;

    /**
    * 创建者
    */
    @Schema(description="创建者")
    private String createBy;

    /**
    * 创建时间
    */
    @Schema(description="创建时间")
    private LocalDateTime createTime;

    /**
    * 更新者
    */
    @Schema(description="更新者")
    private String updateBy;

    /**
    * 更新时间
    */
    @Schema(description="更新时间")
    private LocalDateTime updateTime;

    /**
    * 备注
    */
    @Schema(description="备注")
    private String remark;

    public void convertEntity(DeviceInfoParams deviceInfoParams){
        BeanUtil.copyProperties(deviceInfoParams, this, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
    }

    private static final long serialVersionUID = 1L;
}