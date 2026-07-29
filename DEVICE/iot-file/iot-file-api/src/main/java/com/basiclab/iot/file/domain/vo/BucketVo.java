package com.basiclab.iot.file.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * 桶信息
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
@Schema(description = "桶Vo")
public class BucketVo {
    @Schema(description = "桶名称")
    private String name;
    @Schema(description = "创建时间")
    private ZonedDateTime creationDate;
}
