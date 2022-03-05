package com.gourmetapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web相关配置
 * @author none
 * @date 2020-10-23 - 16:15
 */
@Configuration
public class CustomWebConfiguration implements WebMvcConfigurer {

    @Value("${user.filepath}")
    private String filePath;

    /**
     * 新增资源处理器映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/images/**")
                .addResourceLocations("file:"+ filePath);
    }
}
