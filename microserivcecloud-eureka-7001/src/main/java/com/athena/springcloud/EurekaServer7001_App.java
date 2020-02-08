package com.athena.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: xiaoxiang.zhang
 * @Description:
 * @Date: Create in 2:43 PM 2020/2/1
 */
@SpringBootApplication
@EnableEurekaServer //EurekaServer服务器端启动类，接受其他微服务注册进来
public class EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class, args);
    }
}
