package com.basiclab.iot.visualize.controller.admin.deploy.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 服务部署保存 Request VO")
@Data
public class VisualizeDeploySaveReqVO {

    private Long id;

    @NotBlank(message = "部署名称不能为空")
    @Size(max = 128)
    private String deployName;

    @NotNull(message = "项目编号不能为空")
    private Long projectId;

    @Size(max = 64)
    private String deployCode;

    private LocalDateTime expireTime;
    private String remarks;

}
