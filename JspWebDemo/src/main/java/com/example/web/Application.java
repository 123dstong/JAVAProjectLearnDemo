package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Spring Boot 启动类
 * 内嵌 Tomcat，无需单独安装
 */
@SpringBootApplication
@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("========================================");
        System.out.println("  JSP 项目启动成功!");
        System.out.println("  访问地址: http://localhost:9090");
        System.out.println("========================================");
    }
}