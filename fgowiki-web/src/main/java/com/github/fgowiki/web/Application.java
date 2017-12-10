package com.github.fgowiki.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 */
@SpringBootApplication
@MapperScan("com.github.fgowiki.web.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
