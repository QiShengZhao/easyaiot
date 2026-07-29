package com.basiclab.iot.file.domain.qo;

import com.basiclab.iot.common.domain.PageQo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * SysFileQo
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
@Schema(description = "文件管理Qo")
public class SysFileQo extends PageQo implements Serializable {

    private static final long serialVersionUID = 319717507762690848L;
    @Schema(description = "桶名称")
    String bucketName;
    @Schema(description = "对象名称")
    String objectName;
    @Schema(description = "文件名称")
    String fileName;
    @Schema(description = "前缀")
    String prefix;
    @Schema(description = "文件路径")
    String path;
    @Schema(description = "匹配条件")
    String key;
}
