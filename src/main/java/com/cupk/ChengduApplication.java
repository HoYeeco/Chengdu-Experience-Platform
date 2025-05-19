package com.cupk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cupk.*")
public class ChengduApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChengduApplication.class, args);
    }

}
