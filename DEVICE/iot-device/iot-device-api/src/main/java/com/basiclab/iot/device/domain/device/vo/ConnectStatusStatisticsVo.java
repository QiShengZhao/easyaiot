package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class ConnectStatusStatisticsVo {
    /**
     * 在线状态数量
     */
    @Schema(description = "在线状态数量")
    private Integer onlineStatusAmount;

    /**
     * 离线状态数量
     */
    @Schema(description = "离线状态数量")
    private Integer offlineStatusAmount;
}
