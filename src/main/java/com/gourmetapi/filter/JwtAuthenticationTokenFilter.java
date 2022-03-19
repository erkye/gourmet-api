package com.gourmetapi.filter;

import cn.hutool.core.util.StrUtil;
import com.gourmetapi.service.UserService;
import com.gourmetapi.utils.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * TODO
 *
 * @author lfz
 * @since 2022/3/12 2:25 PM
 */
@Component
@AllArgsConstructor
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //当前上下文中不存在认证信息
        //尝试获取token （token不一定存放在header中，比如也可以当做请求参数进行传递）
        //尝试从token中解析对象 （token中可以存放任何信息）
        //尝试从根据存放在token的信息去找对应的用户信息
        //用户找到用户信息信息 就在当前的认证上下文中进行设置,确保后续的filter能够检测到认证通过
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            String tokenStr = request.getHeader("token");
            if (StrUtil.isNotBlank(tokenStr)) {
                String openCode = JwtUtil.getJwtTokenClaimValue(tokenStr);
                if (StrUtil.isNotBlank(openCode)) {
                    UserDetails myUserDetails = userService.getByOpenCode(openCode);
                    if(myUserDetails != null){
                        Collection<? extends GrantedAuthority> authorities = myUserDetails.getAuthorities();

                        //设置当前上下文的认证信息
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(openCode, "", authorities);
                        authenticationToken.setDetails(myUserDetails);
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }

            }
        }
        //调用下一个过滤器
        chain.doFilter(request, response);
    }
}
