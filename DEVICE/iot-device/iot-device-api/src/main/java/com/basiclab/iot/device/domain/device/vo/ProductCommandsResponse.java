package com.basiclab.iot.device.domain.device.vo;

import com.basiclab.iot.common.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ProductCommandsResponse
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */

/**
    * 产品模型设备响应服务命令属性表
    */
@Schema(description="产品模型设备响应服务命令属性表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@Builder
public class ProductCommandsResponse extends BaseEntity implements Serializable {
    /**
    * id
    */
    @Schema(description="id")
    private Long id;

    /**
    * 命令ID
    */
    @Schema(description="命令ID")
    private Long commandsId;

    /**
    * 服务ID
    */
    @Schema(description="服务ID")
    private Long serviceId;

    ///**
    //* 是否必填(字典值：是  否)
    //*/
    //@Schema(description="是否必填(字典值：是  否)")
    //private String is_required;

    /**
    * 指示数据类型。取值范围：string、int、decimal

    */
    @Schema(description="指示数据类型。取值范围：string、int、decimal,")
    private String datatype;

    /**
    * 指示枚举值。
如开关状态status可有如下取值
"enumList" : ["OPEN","CLOSE"]
目前本字段是非功能性字段，仅起到描述作用。建议准确定义。

    */
    @Schema(description="指示枚举值。,如开关状态status可有如下取值,'enumList' : ['OPEN','CLOSE'],目前本字段是非功能性字段，仅起到描述作用。建议准确定义。,")
    private String enumlist;

    /**
    * 指示最大值。
仅当dataType为int、decimal时生效，逻辑小于等于。
    */
    @Schema(description="指示最大值。,仅当dataType为int、decimal时生效，逻辑小于等于。")
    private Integer max;

    /**
    * 指示字符串长度。
仅当dataType为string时生效。
    */
    @Schema(description="指示字符串长度。,仅当dataType为string时生效。")
    private Integer maxlength;

    /**
    * 指示最小值。
仅当dataType为int、decimal时生效，逻辑大于等于。
    */
    @Schema(description="指示最小值。,仅当dataType为int、decimal时生效，逻辑大于等于。")
    private Integer min;

    /**
    * 命令中参数的描述，不影响实际功能，可配置为空字符串""。
    */
    @Schema(description="命令中参数的描述，不影响实际功能，可配置为空字符串''。")
    private String parameterDescription;

    /**
    * 命令中参数的名字。
    */
    @Schema(description="命令中参数的名字。")
    private String parameterName;

    /**
     * 参数编码。
     */
    @Schema(description="参数编码")
    private String parameterCode;

    /**
    * 指示本条属性是否必填，取值为0或1，默认取值1（必填）。
目前本字段是非功能性字段，仅起到描述作用。
    */
    @Schema(description="指示本条属性是否必填，取值为0或1，默认取值1（必填）。,目前本字段是非功能性字段，仅起到描述作用。")
    private Integer required;

    /**
    * 指示步长。
    */
    @Schema(description="指示步长。")
    private Integer step;

    /**
    * 指示单位。
取值根据参数确定，如：
•温度单位：“C”或“K”
•百分比单位：“%”
•压强单位：“Pa”或“kPa”

    */
    @Schema(description="指示单位。,取值根据参数确定，如：,•温度单位：“C”或“K”,•百分比单位：“%”,•压强单位：“Pa”或“kPa”,")
    private String unit;


    private static final long serialVersionUID = 1L;
}
