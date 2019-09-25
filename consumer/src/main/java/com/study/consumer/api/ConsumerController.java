package com.study.consumer.api;

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

    @RequestMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return restTemplate.getForObject("http://localhost:8080/hello/"+name, String.class);
    }

}
