package com.yzy.tiktokmessage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yzy.tiktokmessage.mapper")
public class TiktokMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiktokMessageApplication.class, args);
    }

}
