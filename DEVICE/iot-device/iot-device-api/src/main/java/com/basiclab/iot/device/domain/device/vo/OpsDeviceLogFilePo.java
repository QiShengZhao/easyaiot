package com.basiclab.iot.device.domain.device.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.basiclab.iot.common.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = false)
@TableName("device_log_file")
@Schema(description = "设备日志文件")
public class OpsDeviceLogFilePo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "设备唯一ID")
    @TableField("device_identification")
    private String deviceIdentification;

    @Schema(description = "应用编码[OS-设备OS]")
    @TableField("app_code")
    private String appCode;

    @Schema(description = "功能编码")
    @TableField("function_code")
    private String functionCode;

    @Schema(description = "功能名称")
    @TableField("function_name")
    private String functionName;

    @Schema(description = "文件地址")
    @TableField("file_url")
    private String fileUrl;

    @Schema(description = "上传时间")
    @TableField("upload_time")
    private LocalDateTime uploadTime;

    @Schema(description = "文件原始名称")
    @TableField("file_name")
    private String fileName;

    @Schema(description = "文件大小(单位KB)")
    @TableField("file_size")
    private Integer fileSize;

    @Schema(description = "备注")
    @TableField("remark")
    private String remark;

    @Schema(description = "状态[0:成功, 1:未开始, 2:上传中, 3:失败]")
    @TableField("status")
    private Integer status;


}
