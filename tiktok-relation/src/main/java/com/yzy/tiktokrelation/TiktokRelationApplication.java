package com.yzy.tiktokrelation;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.yzy.tiktokrelation.mapper")
@EnableDubbo
@EnableDiscoveryClient
public class TiktokRelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiktokRelationApplication.class, args);
    }

}
