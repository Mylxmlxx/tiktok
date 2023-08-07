package com.yzy.tiktokvideo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yzy.tiktokvideo.mapper")
@EnableDubbo
public class TiktokVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiktokVideoApplication.class, args);
    }

}
