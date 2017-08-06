package com.huiyong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.huiyong.dao")
@EnableTransactionManagement
public class SpringPointsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPointsApplication.class, args);
    }
}
