package com.mingyu.springcloud.services;

import com.mingyu.springcloud.domain.CommonResult;
import com.mingyu.springcloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: PaymentFeignService
 * Description:
 * date: 2022/2/11 22:29
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYTMENT-SERVER")
public interface PaymentFeignService {
    @GetMapping(path = "/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
