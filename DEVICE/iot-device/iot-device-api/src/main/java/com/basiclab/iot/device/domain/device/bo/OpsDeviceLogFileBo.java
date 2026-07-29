package com.basiclab.iot.device.domain.device.bo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-06-03
 */
@Data
@ToString
@Schema(description = "设备app和设备系统日志上传接口参数模型")
public class OpsDeviceLogFileBo implements Serializable {

    private static final long serialVersionUID = 508391968106131498L;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "指令版本号同时也是记录主键")
    @NotBlank(message = "version must not be blank")
    private String version;

    @Schema(description = "备注")
    private String remark;
}
