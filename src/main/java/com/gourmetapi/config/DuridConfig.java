package com.gourmetapi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 李发展
 * @date 2020-10-8 - 20:40
 */
@Configuration
public class DuridConfig {

    /**
     * 配置Druid的Bean 读取yml配置中spring.datasource为前缀的配置
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
}
