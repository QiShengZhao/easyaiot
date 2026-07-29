package com.basiclab.iot.device.domain.device.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 设备告警策略（以设备为单位）
 */
@Schema(description = "设备告警策略")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@TableName("device_alarm_strategy")
public class DeviceAlarmStrategy implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @Schema(description = "设备标识")
    private String deviceIdentification;

    @Schema(description = "策略名称")
    private String strategyName;

    @Schema(description = "是否启用")
    private Integer enabled;

    @Schema(description = "通知方式 JSON 数组 sms/email/wxcp/ding/feishu/http")
    private String notifyMethods;

    @Schema(description = "通知人 JSON（由消息模板绑定的用户分组解析写入）")
    private String notifyUsers;

    @Schema(description = "渠道模板配置 JSON：[{method,template_id,template_name,userless?}]")
    private String channels;

    @Schema(description = "告警静默秒数")
    private Integer silenceSeconds;

    @Schema(description = "是否纳入离线健康扣分")
    private Integer includeOffline;

    private String remark;
    private Long tenantId;
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
