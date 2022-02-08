package com.mingyu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName: OrderConsulController
 * Description:
 * date: 2022/2/8 22:07
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@Slf4j
public class OrderConsulController {

    private static final String INVOKE_URL = "http://cloud-provider-paytment-server";

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(path = "/consumer/payment/consul")
    public String orderInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result + "-----" + serverPort;
    }
}
