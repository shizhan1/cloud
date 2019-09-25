package com.study.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.study.ribbonrule.MyRibbonRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author whj
 * @ClassName BeanConfig.java
 * @Description TODO
 * @createTime 2019年09月20日 10:51:00
 */
@Configuration
public class BeanConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule ribbonRule(){
//        //这里配置策略，和配置文件对应
//        return new RandomRule();
//    }

    @Bean
    public IRule myRule(){
        return new MyRibbonRule();
    }
}
