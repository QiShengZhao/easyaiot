package com.basiclab.iot.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link SwaggerAutoConfiguration}（springdoc 版）的装配测试
 *
 * 守护 springfox -> springdoc 迁移：Bean 装配、swagger.* 配置绑定、开关行为与迁移前一致
 */
public class SwaggerAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                    ConfigurationPropertiesAutoConfiguration.class,
                    SwaggerAutoConfiguration.class));

    @Test
    public void testDefaultEnabled_beansPresent() {
        contextRunner.run(context -> {
            // matchIfMissing = true：不配置 swagger.enabled 时默认开启
            assertTrue(context.containsBean("openApi"));
            assertNotNull(context.getBean(OpenAPI.class));
            assertNotNull(context.getBean(GroupedOpenApi.class));
        });
    }

    @Test
    public void testPropertiesBinding() {
        contextRunner
                .withPropertyValues(
                        "swagger.title=EasyAIoT 接口文档",
                        "swagger.version=2.1.0",
                        "swagger.description=测试描述")
                .run(context -> {
                    OpenAPI openApi = context.getBean(OpenAPI.class);
                    assertEquals("EasyAIoT 接口文档", openApi.getInfo().getTitle());
                    assertEquals("2.1.0", openApi.getInfo().getVersion());
                    assertEquals("测试描述", openApi.getInfo().getDescription());
                });
    }

    @Test
    public void testSecurityScheme_authorizationHeaderKept() {
        contextRunner.run(context -> {
            OpenAPI openApi = context.getBean(OpenAPI.class);
            // 与原 springfox 配置语义一致：token 通过 Authorization 请求头传递
            assertNotNull(openApi.getComponents().getSecuritySchemes().get("Authorization"),
                    "必须保留 Authorization 头鉴权 SecurityScheme");
            assertFalse(openApi.getSecurity().isEmpty(), "必须存在全局 SecurityRequirement");
        });
    }

    @Test
    public void testDisabled_noBeans() {
        contextRunner
                .withPropertyValues("swagger.enabled=false")
                .run(context -> {
                    assertFalse(context.containsBean("openApi"));
                    assertFalse(context.containsBean("defaultGroupedOpenApi"));
                });
    }
}
