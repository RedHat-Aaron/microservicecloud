package com.athena.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xiaoxiang.zhang
 * @Description:注解配置对象，这个东西等同于我们的applicationContext.xml
 * @Date: Create in 12:30 AM 2020/2/1
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//Ribbon是基于客户端的负载均衡工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //这样就可以实现使用指定算法来替代默认的轮询算法
        return new RandomRule();
    }
}
