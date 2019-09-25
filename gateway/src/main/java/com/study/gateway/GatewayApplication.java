package com.study.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author whj
 * @ClassName GatewayApplication.java
 * @Description TODO
 * @createTime 2019年09月25日 15:32:00
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GatewayApplication {
}
