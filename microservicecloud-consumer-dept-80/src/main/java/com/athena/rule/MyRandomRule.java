package com.athena.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: xiaoxiang.zhang
 * @Description:自定义轮询每个服务循环五次
 * @Date: Create in 11:11 PM 2020/2/6
 */
public class MyRandomRule extends AbstractLoadBalancerRule {

    /**
     * 已循环次数
     */
    private Integer hasCircled = 0;

    /**
     * 当前服务器下标
     */
    private Integer currentServerIndex = 0;

    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            //接着判断当前服务器调用次数是否达到五次
            if (hasCircled < 5) {
                server = upList.get(currentServerIndex);
                hasCircled++;
            } else {
                //说明该下一个服务器了
                hasCircled = 0;
                if (currentServerIndex < serverCount - 1) {
                    currentServerIndex++;
                } else {
                    currentServerIndex = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
