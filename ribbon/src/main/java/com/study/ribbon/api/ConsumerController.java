package com.study.ribbon.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.ribbon.service.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author whj
 * @ClassName ConsumerController.java
 * @Description TODO
 * @createTime 2019年09月16日 16:24:00
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HelloFeignClient helloFeignClient;
    // 发生异常时，调用fallbackMethod方法，若不配置，则默认抛异常
    @HystrixCommand(fallbackMethod = "helloExection")
    @RequestMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return restTemplate.getForObject("http://PROVIDER-USER/hello/"+name, String.class);
    }


    @RequestMapping("helloFeign/{name}")
    public String helloFeign(@PathVariable String name) {
        return helloFeignClient.hello(name);
    }

    public String helloExection(String name){
        return "hello 404";
    }

}
