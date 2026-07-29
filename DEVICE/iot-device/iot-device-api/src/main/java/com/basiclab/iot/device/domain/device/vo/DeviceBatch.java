package com.basiclab.iot.device.domain.device.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DeviceBatch
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */

@Data
public class DeviceBatch implements Serializable {
    private static final long serialVersionUID = -54159772729593908L;
    /**
     * 主键id
     */
    @Schema(description = "主键id")
    private Long id;
    /**
     * 批次号
     */
    @Schema(description = "批次号")
    private String batchNumber;
    /**
     * 产品名称
     */
    @Schema(description = "产品名称")
    private String productName;
    /**
     * 申请数量
     */
    @Schema(description = "申请数量")
    private Integer applyAmount;
    /**
     * 成功数量
     */
    @Schema(description = "成功数量")
    private Integer successAmount;
    /**
     * 文件路径
     */
    @Schema(description = "文件路径")
    private String fileUrl;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;
    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}

