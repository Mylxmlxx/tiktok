package com.yzy.tiktokgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TiktokGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiktokGatewayApplication.class, args);
    }

}
