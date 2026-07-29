package com.basiclab.iot.gateway.util;

import com.basiclab.iot.gateway.filter.security.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.web.server.ServerWebExchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * {@link SecurityFrameworkUtils} 的单元测试
 *
 * 覆盖网关鉴权关键路径：Bearer Token 解析、伪造 login-user 请求头剥离、登录用户上下文设置
 */
public class SecurityFrameworkUtilsTest {

    // ========== obtainAuthorization ==========

    @Test
    public void testObtainAuthorization_noHeader() {
        ServerWebExchange exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/api/test"));
        assertNull(SecurityFrameworkUtils.obtainAuthorization(exchange));
    }

    @Test
    public void testObtainAuthorization_notBearer() {
        ServerWebExchange exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/api/test")
                .header("Authorization", "Basic dXNlcjpwYXNz"));
        assertNull(SecurityFrameworkUtils.obtainAuthorization(exchange));
    }

    @Test
    public void testObtainAuthorization_bearer() {
        ServerWebExchange exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/api/test")
                .header("Authorization", "Bearer test-token-123"));
        assertEquals("test-token-123", SecurityFrameworkUtils.obtainAuthorization(exchange));
    }

    @Test
    public void testObtainAuthorization_bearerWithSpaces() {
        ServerWebExchange exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/api/test")
                .header("Authorization", "Bearer  token-with-space "));
        assertEquals("token-with-space", SecurityFrameworkUtils.obtainAuthorization(exchange));
    }

    // ========== removeLoginUser：防止伪造请求头透传 ==========

    @Test
    public void testRemoveLoginUser_forgedHeaderStripped() {
        ServerWebExchange exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/api/test")
                .header("login-user", "{\"id\":999,\"tenantId\":1}"));
        ServerWebExchange result = SecurityFrameworkUtils.removeLoginUser(exchange);
        assertFalse(result.getRequest().getHeaders().containsKey("login-user"),
                "伪造的 login-user 请求头必须被网关剥离");
    }

    @Test
    public void testRemoveLoginUser_noHeaderReturnsSameExchange() {
        ServerWebExchange exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/api/test"));
        assertSame(exchange, SecurityFrameworkUtils.removeLoginUser(exchange));
    }

    // ========== setLoginUser / getLoginUserId / getLoginUserType ==========

    @Test
    public void testSetAndGetLoginUser() {
        ServerWebExchange exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/api/test"));
        LoginUser user = new LoginUser().setId(1024L).setUserType(1).setTenantId(1L);

        SecurityFrameworkUtils.setLoginUser(exchange, user);

        assertEquals(1024L, SecurityFrameworkUtils.getLoginUserId(exchange));
        assertEquals(1, SecurityFrameworkUtils.getLoginUserType(exchange));
    }
}
