package com.mingyu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * ClassName: PaymentController
 * Description:
 * date: 2022/2/8 08:06
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(path = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
