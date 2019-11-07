package com.wss.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("项目启动成功");
        SpringApplication.run(DemoApplication.class, args);
    }

}
