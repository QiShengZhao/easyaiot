package com.basiclab.iot.device.domain.app.vo;

import com.basiclab.iot.common.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * App
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description = "应用密钥")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@Builder
public class App extends BaseEntity implements Serializable {

    /**
     * 主键ID
     */
    @Schema(description = "主键ID")
    private Long id;

    /**
     * 应用ID（AppID）：应用的唯一标识
     */
    @Schema(description = "应用ID（AppID）")
    private String appId;

    /**
     * 应用密钥（AppKey）：公匙，相当于账号
     */
    @Schema(description = "应用密钥（AppKey）")
    private String appKey;

    /**
     * 应用密钥（AppSecret）：私匙，相当于密码
     */
    @Schema(description = "应用密钥（AppSecret）")
    private String appSecret;

    /**
     * 应用名称
     */
    @Schema(description = "应用名称")
    private String appName;

    /**
     * 应用描述
     */
    @Schema(description = "应用描述")
    private String appDesc;

    /**
     * 状态：ENABLE-启用，DISABLE-禁用
     */
    @Schema(description = "状态：ENABLE-启用，DISABLE-禁用")
    private String status;

    /**
     * 权限类型：READ_ONLY-只读，READ_WRITE-读写
     */
    @Schema(description = "权限类型：READ_ONLY-只读，READ_WRITE-读写")
    private String permissionType;

    /**
     * 过期时间
     */
    @Schema(description = "过期时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expireTime;

    /**
     * 租户编号
     */
    @Schema(description = "租户编号")
    private Long tenantId;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;
}

