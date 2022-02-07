package com.mingyu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: PaymentMian8001
 * Description:
 * date: 2022/2/1 12:56
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication
@MapperScan("com.mingyu.springcloud.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
