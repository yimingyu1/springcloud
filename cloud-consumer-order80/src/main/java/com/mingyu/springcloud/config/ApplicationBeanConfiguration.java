package com.mingyu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ApplicationBeanConfiguration
 * Description:
 * date: 2022/2/1 20:28
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
