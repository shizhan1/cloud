package com.study.producer.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whj
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2019年09月16日 11:40:00
 */

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping({"/","/index"})
    public String index(){
        return "welcome index";
    }

    @RequestMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        if ("exection".equals(name)) {
            throw new RuntimeException();
        }
        return "hello " + name + "----by " + port;
    }
}
