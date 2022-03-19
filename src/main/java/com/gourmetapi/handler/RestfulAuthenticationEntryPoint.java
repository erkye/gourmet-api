package com.gourmetapi.handler;

import com.alibaba.fastjson.JSON;
import com.gourmetapi.model.result.ResultCode;
import com.gourmetapi.model.result.ResultVo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证信息失效处理
 *
 * @author lfz
 * @since 2022/3/12 2:15 PM
 */
@Component
public class RestfulAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(200);
        ResultVo<?> resultVo = new ResultVo<>(ResultCode.AUTH_INVALID,null);
        response.getWriter().println(JSON.toJSONString(resultVo));
        response.getWriter().flush();
    }
}
