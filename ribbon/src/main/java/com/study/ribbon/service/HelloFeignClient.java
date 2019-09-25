package com.study.ribbon.service;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author whj
 * @ClassName HelloFeignClient.java
 * @Description TODO
 * @createTime 2019年09月23日 10:55:00
 */

//name=请求服务名称
@FeignClient(name="provider-user", fallbackFactory = HelloFeignClientFallbackFactory.class)
public interface HelloFeignClient {

    @GetMapping("/hello/{name}")
    String hello(@PathVariable("name") String name);
}

@Component
class HelloFeignClientFallbackFactory implements FallbackFactory<HelloFeignClient> {
    @Override
    public HelloFeignClient create(Throwable throwable) {
        return new HelloFeignClient() {
            @Override
            public String hello(String name) {
                return "hello hystrix 404";
            }
        };
    }
}
