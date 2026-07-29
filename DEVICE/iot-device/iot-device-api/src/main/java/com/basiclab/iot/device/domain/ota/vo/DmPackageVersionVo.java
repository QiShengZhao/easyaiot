package com.basiclab.iot.device.domain.ota.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-05-27
 */
@Data
@Schema(description = "DmPackageVersionVo对象")
public class DmPackageVersionVo implements Serializable {
    private String version;
}