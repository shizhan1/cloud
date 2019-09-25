package com.study.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author whj
 * @ClassName TurbineApplication.java
 * @Description 监控 访问地址：http://localhost:8031/turbine.stream
 * @createTime 2019年09月24日 17:17:00
 */
//turbine
@EnableTurbine
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }
}
