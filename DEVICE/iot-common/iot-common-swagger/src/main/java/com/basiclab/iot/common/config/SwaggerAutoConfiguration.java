package com.basiclab.iot.common.config;

import java.util.Arrays;
import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

/**
 * 基于 springdoc 的接口文档自动配置（替代原 springfox Docket 实现）。
 * 复用 SwaggerProperties（prefix = "swagger"），原有 yaml 配置无需调整。
 */
@Configuration
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration
{
    /**
     * 默认的排除路径，排除Spring Boot默认的错误处理路径和端点
     */
    private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

    private static final String BASE_PATH = "/**";

    /** 与原 springfox 配置一致：token 通过 Authorization 请求头传递 */
    private static final String SECURITY_SCHEME_NAME = "Authorization";

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties()
    {
        return new SwaggerProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public OpenAPI openApi(SwaggerProperties swaggerProperties)
    {
        return new OpenAPI()
                .info(new Info()
                        .title(swaggerProperties.getTitle())
                        .description(swaggerProperties.getDescription())
                        .version(swaggerProperties.getVersion())
                        .termsOfService(swaggerProperties.getTermsOfServiceUrl())
                        .contact(new Contact()
                                .name(swaggerProperties.getContact().getName())
                                .url(swaggerProperties.getContact().getUrl())
                                .email(swaggerProperties.getContact().getEmail()))
                        .license(new License()
                                .name(swaggerProperties.getLicense())
                                .url(swaggerProperties.getLicenseUrl())))
                .components(new Components().addSecuritySchemes(SECURITY_SCHEME_NAME,
                        new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER)
                                .name(SECURITY_SCHEME_NAME)))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME));
    }

    @Bean
    @ConditionalOnMissingBean
    public GroupedOpenApi defaultGroupedOpenApi(SwaggerProperties swaggerProperties)
    {
        // base-path处理
        List<String> basePath = swaggerProperties.getBasePath();
        if (basePath.isEmpty())
        {
            basePath.add(BASE_PATH);
        }
        // exclude-path处理
        List<String> excludePath = swaggerProperties.getExcludePath();
        if (excludePath.isEmpty())
        {
            excludePath.addAll(DEFAULT_EXCLUDE_PATH);
        }

        GroupedOpenApi.Builder builder = GroupedOpenApi.builder()
                .group("default")
                .pathsToMatch(basePath.toArray(new String[0]))
                .pathsToExclude(excludePath.toArray(new String[0]));
        if (!swaggerProperties.getBasePackage().isEmpty())
        {
            builder.packagesToScan(swaggerProperties.getBasePackage());
        }
        return builder.build();
    }
}
