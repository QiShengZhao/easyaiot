package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 物模型服务入参/出参（前端编辑与设备控制共用）
 */
@Schema(description = "物模型服务参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductServiceParamVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "参数记录ID")
    private Long id;

    @Schema(description = "参数标识（前端兼容 propertyCode）")
    private String parameterCode;

    @Schema(description = "参数名称（前端兼容 propertyName）")
    private String parameterName;

    /** 前端表单字段兼容 */
    private String propertyCode;
    private String propertyName;

    @Schema(description = "数据类型 INT/DOUBLE/BOOL/TEXT 等")
    private String datatype;

    @Schema(description = "最小值")
    private Integer min;

    @Schema(description = "最大值")
    private Integer max;

    @Schema(description = "步长")
    private Integer step;

    @Schema(description = "字符串最大长度")
    private Integer maxlength;

    @Schema(description = "单位")
    private String unit;

    @Schema(description = "枚举/布尔描述 JSON")
    private String enumlist;

    @Schema(description = "是否必填 0/1")
    private Integer required;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "描述（兼容 parameterDescription）")
    private String parameterDescription;

    private String boolClose;
    private String boolOpen;
}
