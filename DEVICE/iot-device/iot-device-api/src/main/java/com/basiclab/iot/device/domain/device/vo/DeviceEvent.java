package com.basiclab.iot.device.domain.device.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 设备动作数据
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Schema(description = "设备动作数据")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@Builder
@TableName("device_event")
public class DeviceEvent implements Serializable {
    /**
     * id
     */
    @Schema(description = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 设备标识
     */
    @Schema(description = "设备标识")
    private String deviceIdentification;

    /**
     * 事件名称
     */
    @Schema(description = "事件名称")
    private String eventName;

    /**
     * 事件标识符
     */
    @Schema(description = "事件标识符")
    private String eventCode;

    /**
     * 动作类型
     */
    @Schema(description = "事件类型")
    private String eventType;

    /**
     * 状态
     */
    @Schema(description = "状态")
    private String status;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 内容信息
     */
    @Schema(description = "内容信息")
    private String message;

    /**
     * 租户编号
     */
    @Schema(description = "租户编号")
    private Long tenantId;

    /**
     * 查询起始时间（非表字段）
     */
    @Schema(description = "查询起始时间")
    @TableField(exist = false)
    private LocalDateTime startTime;

    /**
     * 查询结束时间（非表字段）
     */
    @Schema(description = "查询结束时间")
    @TableField(exist = false)
    private LocalDateTime endTime;

    private static final long serialVersionUID = 1L;
}