package com.basiclab.iot.device.domain.device.qo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

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
@Schema(description = "终端上下线入参通知实体")
public class OnlineQo implements Serializable {

    @Schema(description = "terminal（终端类型,设备端：device）")
    private String terminal;

    @Schema(description = "deviceIdengtification（设备唯一deviceIdengtification）")
    private String deviceIdengtification;

    @Schema(description = "userId（用户ID）")
    private Long userId;

    @Schema(description = "online（是否上线或离线）")
    private String status;

    public OnlineQo(){
    }

    public OnlineQo(String deviceIdengtification, String status){
        this.deviceIdengtification = deviceIdengtification;
        this.status = status;
    }
}
