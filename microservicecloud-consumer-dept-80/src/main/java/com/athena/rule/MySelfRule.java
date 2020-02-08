package com.athena.rule;

import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xiaoxiang.zhang
 * @Description:手动设置默认的负载均衡算法
 * @Date: Create in 10:59 PM 2020/2/6
 */
@Configuration
public class MySelfRule{

    @Bean
    public IRule myRule() {
        return new MyRandomRule();
    }
}
