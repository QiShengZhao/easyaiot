package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

/**
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
public class DeviceBatchInsertReq {

    /**
     * 产品标识
     */
    @Schema(description = "产品标识")
    @NotNull(message = "产品标识不能为空")
    private String productIdentification;
    /**
     * 添加方式
     */
    @Schema(description = "添加方式, 1.自动生成 2.批量上传")
    @NotNull(message = "添加方式不能为空")
    private Integer addType;
    /**
     * 设备数量
     */
    @Schema(description = "设备数量")
    private Integer deviceCount;
    /**
     * 文件路径
     */
    @Schema(description = "文件id")
    private String fileId;

    @Schema(description = "批次号", hidden = true)
    private String batchNumber;

    @Getter
    public static enum AddTypeEnum {
        /**
         * 自动生成
         */
        AUTOMATIC_GENERATED(1),
        /**
         * 批量上传
         */
        BATCH_UPLOAD(2)
        ;

        private Integer typeNum;

        AddTypeEnum(Integer typeNum) {
            this.typeNum = typeNum;
        }

    }
}
