package com.basiclab.iot.device.domain.product.vo.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 表单保存方法VO
 * 产品模型
 * </p>
 *
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 * @date 2023-03-14 19:39:59
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode
@Builder
@Schema(description = "产品模型参数VO")
public class ProductParamVO implements Serializable {

    /**
     * id
     */
    @Schema(description = "id")
    private Long id;


    /**
     * 应用ID
     */
    @Schema(description = "应用ID")
    private String appId;

    /**
     * 产品模版标识
     */
    @Schema(description = "产品模版标识")
    private String templateIdentification;

    /**
     * 产品名称:自定义，支持中文、英文大小写、数字、下划线和中划线
     */
    @Schema(description = "产品名称:自定义，支持中文、英文大小写、数字、下划线和中划线")
    private String productName;

    /**
     * 产品标识
     */
    @Schema(description = "产品标识")
    private String productIdentification;

    /**
     * 支持以下两种产品类型•COMMON：普通产品，需直连设备。
     * •GATEWAY：网关产品，可挂载子设备。
     */
    @Schema(description = "支持以下两种产品类型•COMMON：普通产品，需直连设备。,•GATEWAY：网关产品，可挂载子设备。,•SUBSET：子设备。")
    private String productType;

    /**
     * 厂商ID:支持英文大小写，数字，下划线和中划线
     */
    @Schema(description = "厂商ID:支持英文大小写，数字，下划线和中划线")
    private String manufacturerId;

    /**
     * 厂商名称 :支持中文、英文大小写、数字、下划线和中划线
     */
    @Schema(description = "厂商名称 :支持中文、英文大小写、数字、下划线和中划线")
    private String manufacturerName;

    /**
     * 产品型号，建议包含字母或数字来保证可扩展性。支持英文大小写、数字、下划线和中划线
     */
    @Schema(description = "产品型号，建议包含字母或数字来保证可扩展性。支持英文大小写、数字、下划线和中划线,")
    private String model;

    /**
     * 数据格式，默认为JSON无需修改。
     */
    @Schema(description = "数据格式，默认为JSON无需修改。")
    private String dataFormat;

    /**
     * 设备类型:支持英文大小写、数字、下划线和中划线
     */
    @Schema(description = "设备类型:支持英文大小写、数字、下划线和中划线,")
    private String deviceType;

    /**
     * 设备接入平台的协议类型，默认为MQTT无需修改。
     */
    @Schema(description = "设备接入平台的协议类型，默认为MQTT无需修改。, ")
    private String protocolType;

    /**
     * 状态(字典值：0启用  1停用)
     */
    @Schema(description = "状态(字典值：0启用  1停用)")
    private String status;

    /**
     * 产品描述
     */
    @Schema(description = "产品描述")
    private String remark;


    @Schema(description = "产品模型服务")
    private List<ProductServiceParamVO> services;

}
