package com.mingyu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName: OrderZKController
 * Description:
 * date: 2022/2/8 08:31
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@Slf4j
public class OrderZKController {

    private static final String INVOKE_URL = "http://cloud-provider-paytment-server";

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(path = "/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result + "---" + serverPort;
    }
}
