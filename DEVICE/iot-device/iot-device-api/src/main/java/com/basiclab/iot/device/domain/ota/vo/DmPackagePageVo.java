package com.basiclab.iot.device.domain.ota.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

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
@Schema(description = "版本包")
public class DmPackagePageVo implements Serializable {

    private static final long serialVersionUID = 7223864037660091822L;
    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    private Long id;
    /**
     * 包类型[0:app,1:系统,2:电控]
     */
    @Schema(description = "包类型[0:app,1:系统,2:电控]")
    private String type;
    /**
     * 包版本号
     */
    @Schema(description = "包版本号")
    private String version;
    /**
     * 包名称
     */
    @Schema(description = "包名称")
    private String name;
    /**
     * 升级方式[0:非强制升级,1:强制升级]
     */
    @Schema(description = "升级方式[0:非强制升级,1:强制升级]")
    private Integer upgradeMode;
    /**
     * 上传时间
     */
    @Schema(description = "上传时间")
    private LocalDateTime uploadTime;
    /**
     * 发布时间
     */
    @Schema(description = "发布时间")
    private LocalDateTime publishTime;
    /**
     * 发布时间
     */
    @Schema(description = "上传时间")
    private LocalDateTime updatedTime;
    /**
     * 关键版本标识[0:否,1:是]
     */
    @Schema(description = "关键版本标识[0:否,1:是]")
    private Integer keyVersionFlag;
    /**
     * 状态[0:未验证,1:已验证,2:已发布]
     */
    @Schema(description = "状态[0:未验证,1:已验证,2:已发布]")
    private Integer status;
    /**
     * 图片地址
     */
    @Schema(description = "图片地址")
    private String url;
    /**
     * 系统类型
     */
    @Schema(description = "系统类型")
    private Integer systemType;
    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;
}