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
 * 设备属性阈值
 */
@Schema(description = "设备属性阈值")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@TableName("device_property_threshold")
public class DevicePropertyThreshold implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @Schema(description = "设备标识")
    private String deviceIdentification;

    @Schema(description = "属性标识")
    private String propertyCode;

    @Schema(description = "属性名称")
    private String propertyName;

    @Schema(description = "下限")
    private Double minValue;

    @Schema(description = "上限")
    private Double maxValue;

    @Schema(description = "是否启用 1启用 0停用")
    private Integer enabled;

    @Schema(description = "告警级别 INFO/WARNING/CRITICAL")
    private String alarmLevel;

    private String remark;

    @Schema(description = "运算符阈值规则 JSON 数组")
    private String rulesJson;

    @Schema(description = "健康权重 1-100")
    private Integer healthWeight;

    @Schema(description = "关键属性 1是 0否")
    private Integer critical;

    private Long tenantId;
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
