package com.gourmetapi.config;

import com.gourmetapi.filter.JwtAuthenticationTokenFilter;
import com.gourmetapi.handler.RestfulAccessDeniedHandler;
import com.gourmetapi.handler.RestfulAuthenticationEntryPoint;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 配置类
 *
 * @author lfz
 * @since 2022/3/12 2:45 PM
 */
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    private final RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint;

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //不使用防跨站攻击
        http.csrf().disable()
                //不使用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**").permitAll()
                .and()
                //允许登录接口、注册接口访问
                .authorizeRequests().antMatchers("/admin/login", "/admin/register").permitAll()
                .and()
                //配置跨域的option请求，跨域请求之前都会进行一次option请求
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
                .and()
                //其他没有配置的请求都需要身份认证
                .authorizeRequests().anyRequest().authenticated();
        http.headers().cacheControl();//http的cache控制，如下这句代码会禁用cache
        //添加JWT身份认证的filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权的处理器
        http.exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler);
        //添加自定义未登录的处理器
        http.exceptionHandling().authenticationEntryPoint(restfulAuthenticationEntryPoint);
    }
}
