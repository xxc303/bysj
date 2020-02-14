package com.bdu.jiajiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@MapperScan("com.bdu.jiajiao.mapper")
public class JiajiaoApplication{

    public static void main(String[] args) {
        SpringApplication.run(JiajiaoApplication.class, args);
    }

}
