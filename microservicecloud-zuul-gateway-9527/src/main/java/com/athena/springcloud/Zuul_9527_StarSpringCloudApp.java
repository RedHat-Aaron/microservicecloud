package com.athena.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: xiaoxiang.zhang
 * @Description:
 * @Date: Create in 12:57 AM 2020/2/8
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StarSpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StarSpringCloudApp.class,args);
    }
}
