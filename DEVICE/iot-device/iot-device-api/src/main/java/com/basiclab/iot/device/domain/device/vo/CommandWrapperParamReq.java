package com.basiclab.iot.device.domain.device.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * 在线调试请求参数实体
 * @author 翱翔的雄库鲁
 * @email andywebjava@163.com
 * @wechat EasyAIoT2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
@Schema(description = "Device Command Request Wrapper Data Structure")
public class CommandWrapperParamReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "设备标识列表")
    private List<String> deviceIdentificationList;

    @Schema(description = "产品标识")
    @NotEmpty(message = "产品标识不能为空")
    private String productIdentification;

    @Schema(description = "串行命令请求列表")
    private List<CommandIssueRequestParam> serial;

    @Schema(description = "并行命令请求列表")
    private List<CommandIssueRequestParam> parallel;
}
