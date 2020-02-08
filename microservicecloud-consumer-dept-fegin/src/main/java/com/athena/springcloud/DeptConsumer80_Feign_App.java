package com.athena.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: xiaoxiang.zhang
 * @Description:
 * @Date: Create in 12:53 AM 2020/2/1
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.athena.springcloud"})
//注意！！！这里有个坑就是，这里只能写到域名倒写，千万不能写子包，不然读取不出来
//@ComponentScan(basePackages = "com.athena.springcloud.interfaces")//这个是错误的
@ComponentScan(basePackages = "com.athena.springcloud")
public class DeptConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class, args);
    }
}
