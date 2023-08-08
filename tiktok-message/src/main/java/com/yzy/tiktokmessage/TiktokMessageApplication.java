package com.yzy.tiktokmessage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.yzy.tiktokmessage.mapper")
@EnableDiscoveryClient
public class TiktokMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiktokMessageApplication.class, args);
    }

}
