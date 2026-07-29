package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 更新设备地图坐标请求
 */
@Schema(description = "更新设备地图坐标")
@Data
public class DeviceLocationUpdateParam implements Serializable {

    @Schema(description = "经度（与纬度成对；都为空表示清除坐标）")
    private BigDecimal longitude;

    @Schema(description = "纬度（与经度成对；都为空表示清除坐标）")
    private BigDecimal latitude;

    @Schema(description = "位置名称/地址")
    private String address;

    @Schema(description = "省/直辖市编码")
    private String provinceCode;

    @Schema(description = "市编码")
    private String cityCode;

    @Schema(description = "区县编码")
    private String regionCode;

    @Schema(description = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}
