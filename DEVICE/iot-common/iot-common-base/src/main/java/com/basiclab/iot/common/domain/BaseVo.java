package com.basiclab.iot.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-05-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "id", example = "admin")
    protected Long id;

    @Schema(description = "创建人", example = "admin")
    protected String createdBy;

    @Schema(description = "创建时间", example = "2020/7/16 14:31:27")
    protected LocalDateTime createdTime;

    @Schema(description = "更新人", example = "admin")
    protected String updatedBy;

    @Schema(description = "更新时间", example = "2020/7/16 14:31:27")
    protected LocalDateTime updatedTime;
}
