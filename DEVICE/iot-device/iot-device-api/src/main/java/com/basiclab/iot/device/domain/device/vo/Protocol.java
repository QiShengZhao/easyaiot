package com.basiclab.iot.device.domain.device.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* @description: ${description}
* @packagename: com.basiclab.iot.device.api.domain.protocol
* @author 翱翔的雄库鲁
* @email andywebjava@163.com
* @wechat EasyAIoT2025
* @date: 2025-07-01 17:56
**/

/**
    * 协议信息表
    */
@Schema(description="协议信息表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@Builder
@TableName("protocol")
public class Protocol implements Serializable {
    /**
    * id
    */
    @Schema(description="id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @Schema(description="应用ID")
    private String appId;
    /**
    * 产品标识
    */
    @Schema(description="产品标识")
    private String productIdentification;

    /**
    * 协议名称
    */
    @Schema(description="协议名称")
    private String protocolName;

    /**
    * 协议标识
    */
    @Schema(description="协议标识")
    private String protocolIdentification;

    /**
    * 协议版本
    */
    @Schema(description="协议版本")
    private String protocolVersion;

    /**
    * 协议类型 ：mqtt || coap || modbus || http
    */
    @Schema(description="协议类型 ：mqtt || coap || modbus || http")
    private String protocolType;

    /**
    * 协议语言
    */
    @Schema(description="协议语言")
    private String protocolVoice;

    /**
    * 类名
    */
    @Schema(description="类名")
    private String className;

    /**
    * 文件地址
    */
    @Schema(description="文件地址")
    private String filePath;

    /**
    * 内容
    */
    @Schema(description="内容")
    private String content;

    /**
    * 状态(字典值：0启用  1停用)
    */
    @Schema(description="状态(字典值：0启用  1停用)")
    private String status;

    /**
    * 创建者
    */
    @Schema(description="创建者")
    private String createBy;

    /**
    * 创建时间
    */
    @Schema(description="创建时间")
    private LocalDateTime createTime;

    /**
    * 更新者
    */
    @Schema(description="更新者")
    private String updateBy;

    /**
    * 更新时间
    */
    @Schema(description="更新时间")
    private LocalDateTime updateTime;

    /**
    * 备注
    */
    @Schema(description="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}