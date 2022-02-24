package com.mingyu.springcloud.service.impl;

import com.mingyu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * ClassName: PaymentFallbackService
 * Description:
 * date: 2022/2/24 08:00
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK  fallback";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut fallback";
    }
}
