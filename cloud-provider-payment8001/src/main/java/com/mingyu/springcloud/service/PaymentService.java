package com.mingyu.springcloud.service;

import com.mingyu.springcloud.domain.Payment;

/**
 * ClassName: PaymentService
 * Description:
 * date: 2022/2/1 19:38
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
