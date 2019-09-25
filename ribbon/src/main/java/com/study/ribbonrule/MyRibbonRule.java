package com.study.ribbonrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author whj
 * @ClassName MyRibbonRule.java
 * @Description 自定义负载均衡
 * @createTime 2019年09月23日 10:13:00
 */
public class MyRibbonRule extends AbstractLoadBalancerRule {

    // 总共被调用的次数，目前要求每天被调用5次
    private int total = 0;
    // 当前提供服务的机器号
    private int currentIndex = 0;

    @Override
    public Server choose(Object key) {
        ILoadBalancer lb = getLoadBalancer();
//        System.out.println("lb:"+lb);
//        System.out.println("key:" + key);
        if (lb == null) {
            return null;
        }



        Server server = null;
        while (server == null) {
            List<Server> upList = lb.getReachableServers();
//            System.out.println("upList:" + upList);
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            if (total < 5) {
                total++;
            } else {
                total = 0;
                currentIndex++;
                currentIndex = currentIndex >= upList.size() ? 0 : currentIndex;
            }
            server = upList.get(currentIndex);

        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
