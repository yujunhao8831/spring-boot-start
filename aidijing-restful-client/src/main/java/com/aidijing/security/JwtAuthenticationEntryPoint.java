package com.aidijing.security;

import com.aidijing.common.ResponseEntity;
import com.aidijing.common.util.JsonUtils;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * {@link AuthenticationEntryPoint} 拒绝所有请求与未经授权的错误消息。
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = - 8970718410437077606L;

    @Override
    public void commence ( HttpServletRequest request,
                           HttpServletResponse response,
                           AuthenticationException authException ) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
        // response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "未授权" );
        response.setHeader( "Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE );
        response.setCharacterEncoding( "UTF-8" );
        try ( PrintWriter out = response.getWriter() ) {
            out.print( JsonUtils.toJson( ResponseEntity.unauthorized( "未经授权:身份验证令牌丢失或无效。" ) ) );
        }
    }
}