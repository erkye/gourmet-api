package com.gourmetapi.handler;

import com.alibaba.fastjson.JSON;
import com.gourmetapi.pojo.result.ResultCode;
import com.gourmetapi.pojo.result.ResultVo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问没有授权时的处理器
 *
 * @author lfz
 * @since 2022/3/12 11:15 AM
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(200);
        // 权限不足
        ResultVo<?> resultVo = new ResultVo<>(ResultCode.PERMISSIONS_INSUFFICIENT,null);
        response.getWriter().println(JSON.toJSONString(resultVo));
        response.getWriter().flush();
    }
}
