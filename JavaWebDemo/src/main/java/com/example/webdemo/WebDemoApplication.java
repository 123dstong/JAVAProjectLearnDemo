package com.example.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);
        System.out.println("========================================");
        System.out.println("  Spring Boot Web 项目启动成功!");
        System.out.println("  访问地址: http://localhost:8088");
        System.out.println("========================================");
    }
}