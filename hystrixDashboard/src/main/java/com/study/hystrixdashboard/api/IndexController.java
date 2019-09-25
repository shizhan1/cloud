package com.study.hystrixdashboard.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author whj
 * @ClassName IndexController.java
 * @Description TODO
 * @createTime 2019年09月24日 17:20:00
 */
@Controller
public class IndexController {
    @GetMapping("")
    public String index() {
        return "forward:/hystrix";
    }
}
