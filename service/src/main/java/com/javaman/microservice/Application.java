package com.javaman.microservice;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pengzhe
 * @date 2019-05-09 22:03
 * @description
 * zookeeper 可视化 https://blog.csdn.net/uisoul/article/details/78226324
 */
@SpringBootApplication
@EnableDubbo
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
