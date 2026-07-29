package com.basiclab.iot.device.domain.ota.qo;

import com.basiclab.iot.common.domain.PageQo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @desc
 * @created 2025-05-28
 */
@Data
@Schema(description = "版本包列表实体对象Qo")
public class DmPackagePageQo extends PageQo implements Serializable {

    private static final long serialVersionUID = 7223864037660091822L;
    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    private Long id;
    /**
     * 包类型[0:app,1:系统,2:电控]
     */
    @Schema(description = "版本包类型[0:app,1:系统,2:电控]  目前只有 0、1")
    private Integer type;
    /**
     * 包版本号
     */
    @Schema(description = "包版本号")
    private String version;
    /**
     * 产品ID
     */
    @Schema(description = "产品ID")
    private String productId;

}