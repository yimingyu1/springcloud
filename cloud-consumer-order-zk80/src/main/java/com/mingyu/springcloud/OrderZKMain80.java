package com.mingyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: OrderZKMain80
 * Description:
 * date: 2022/2/8 08:29
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class, args);
    }
}
