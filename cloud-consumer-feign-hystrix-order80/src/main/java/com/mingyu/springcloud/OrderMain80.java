package com.mingyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: OrderMain80
 * Description:
 * date: 2022/2/14 08:32
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableFeignClients
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
