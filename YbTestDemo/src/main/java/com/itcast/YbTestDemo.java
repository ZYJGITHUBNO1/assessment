package com.itcast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.itcast.mapping")
@SpringBootApplication
public class YbTestDemo {
    public static void main(String[] args) {
        SpringApplication.run(YbTestDemo.class,args);
    }
}
