package com.mingyu.springcloud.controller;

import com.mingyu.springcloud.domain.CommonResult;
import com.mingyu.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName: PaymentController
 * Description:
 * date: 2022/2/1 20:32
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@Slf4j
public class PaymentController {

    private static final String URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(path = "/consumer/payment/payment-obj")
    public CommonResult<Integer> createPayment(@RequestBody Payment payment){
         return restTemplate.postForObject(URL + "/payment/payment-obj", payment, CommonResult.class);
    }

    @GetMapping(path = "/consumer/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(URL + "/payment/"+ id, CommonResult.class);
    }
}
