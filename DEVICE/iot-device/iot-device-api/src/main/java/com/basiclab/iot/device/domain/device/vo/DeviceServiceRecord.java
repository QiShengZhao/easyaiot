package com.basiclab.iot.device.domain.device.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 设备服务记录管理
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Schema(description="设备服务记录")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@Builder
@TableName("device_service_records")
public class DeviceServiceRecord implements Serializable {
    /**
    * id
    */
    @Schema(description="id")
    private Long id;

    /**
     * 设备标识
     */
    @Schema(description = "设备标识")
    private String deviceIdentification;

    /**
     * 服务标识符
     */
    @Schema(description = "服务标识符")
    private String serviceCode;

    /**
     * 命令标识符
     */
    @Schema(description = "命令标识符")
    private String commandCode;

    /**
     * 命令名称
     */
    @Schema(description = "命令名称")
    private String commandName;

    /**
     * 协议类型 ：mqtt || coap || modbus || http
     */
    @Schema(description = "协议类型 ：mqtt || coap || modbus || http")
    private String protocolType;

    /**
     * 消息ID
     */
    @Schema(description = "消息ID")
    private String messageId;

    /**
     * topic
     */
    @Schema(description = "topic")
    private String topic;

    /**
     * 输入参数
     */
    @Schema(description = "设备请求消息")
    private String request;

    /**
     * 内容信息
     */
    @Schema(description = "设备响应内容信息")
    private String message;

    /**
     * 状态
     */
    @Schema(description = "状态 0.未下发 1.已下发 2.已回复")
    private Integer status;

    /**
     * 响应上报时间
     */
    @Schema(description = "响应上报时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reportTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;


    public enum statusEnum {
        /**
         * 未下发
         */
        UNSENT(0),
        /**
         * 已发送
         */
        SENT(1),
        /**
         * 已回复
         */
        Replied(2)
        ;

        private Integer statusNum;

        statusEnum(Integer statusNum) {
            this.statusNum = statusNum;
        }

        public Integer getStatusNum() {
            return statusNum;
        }
    }
}