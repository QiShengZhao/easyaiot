package com.basiclab.iot.device.domain.device.qo;

import com.basiclab.iot.common.domain.PageQo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-06-03
 */
@Data
@ToString
@Schema(description = "分页查询设备上报日志记录接口参数模型")
public class OpsDeviceLogPageQueryQo extends PageQo {

    private static final long serialVersionUID = -5357130766490913044L;

    @Schema(description = "设备唯一ID")
    private String deviceIdentification;
}
