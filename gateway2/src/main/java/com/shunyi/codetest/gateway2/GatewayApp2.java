package com.shunyi.codetest.gateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Shunyi Chen
 * @create 2021-05-24 10:20
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApp2 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApp2.class, args);
    }
}
