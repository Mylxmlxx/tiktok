package com.yzy.tiktokrelation;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yzy.tiktokrelation.mapper")
@EnableDubbo
public class TiktokRelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiktokRelationApplication.class, args);
    }

}
