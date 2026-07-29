package com.basiclab.iot.device.domain.ota.oo;

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
@Schema(description = "版本包编辑Oo")
public class DmPackageEditOo implements Serializable {
    private static final long serialVersionUID = 4046784516959790027L;
    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    private Long id;
    /**
     * 包类型[0:app,1:系统,2:电控]
     */
    @Schema(description = "包类型[0:app,1:系统,2:电控]")
    private Integer type;
    /**
     * 包名称
     */
    @Schema(description = "包名称")
    private String name;
    /**
     * 产品类型ID(dm_product_type.id)
     */
    @Schema(description = "产品类型ID(dm_product_type.id)")
    private Integer productTypeId;
    /**
     * 产品ID(dm_product.id)
     */
    @Schema(description = "产品ID(dm_product.id)")
    private Integer productId;
    /**
     * 包版本号
     */
    @Schema(description = "包版本号")
    private String version;
    /**
     * 升级方式[0:非强制升级,1:强制升级]
     */
    @Schema(description = "升级方式[0:非强制升级,1:强制升级]")
    private Integer upgradeMode;
    /**
     * 包路径
     */
    @Schema(description = "包路径")
    private String url;
    /**
     * 文件Md5值
     */
    @Schema(description = "文件Md5值")
    private String md5;
    /**
     * 关键版本标识[0:否,1:是]
     */
    @Schema(description = "关键版本标识[0:否,1:是]")
    private Integer keyVersionFlag;
    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;
}