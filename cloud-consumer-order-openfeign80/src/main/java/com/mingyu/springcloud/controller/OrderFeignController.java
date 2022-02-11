package com.mingyu.springcloud.controller;

import com.mingyu.springcloud.domain.CommonResult;
import com.mingyu.springcloud.domain.Payment;
import com.mingyu.springcloud.services.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: OrderFeignController
 * Description:
 * date: 2022/2/11 22:31
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String timeout()
    {
        return paymentFeignService.timeout();
    }

}
