package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-06-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode
@Builder
@Schema(description = "设备向网关发送消息vo")
public class DeviceToGateWayVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "下发设备的信息")
    private CommandIssueRequestParam commandIssueRequestParamVo;


    @Schema(description = "扩展信息（网关需要使用消息）")
    private ExtendInfoVo extendInfo;


}
