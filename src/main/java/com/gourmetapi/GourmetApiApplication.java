package com.gourmetapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.gourmetapi.dao")
public class GourmetApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GourmetApiApplication.class, args);
    }

}
