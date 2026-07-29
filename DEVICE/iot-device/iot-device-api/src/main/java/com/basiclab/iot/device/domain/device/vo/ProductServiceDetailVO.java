package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 物模型服务详情（含入参/出参，供产品编辑与设备控制）
 */
@Schema(description = "物模型服务详情")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductServiceDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "服务ID")
    private Long id;

    @Schema(description = "服务标识")
    private String serviceCode;

    @Schema(description = "服务名称")
    private String serviceName;

    @Schema(description = "产品标识")
    private String productIdentification;

    @Schema(description = "模板标识")
    private String templateIdentification;

    @Schema(description = "状态")
    private String status;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "默认命令ID（内部同步用）")
    private Long commandId;

    @Schema(description = "入参列表")
    @Builder.Default
    private List<ProductServiceParamVO> inputParams = new ArrayList<>();

    @Schema(description = "出参列表")
    @Builder.Default
    private List<ProductServiceParamVO> outParams = new ArrayList<>();
}
