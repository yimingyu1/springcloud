package com.mingyu.springcloud.service.impl;

import com.mingyu.springcloud.dao.PaymentDao;
import com.mingyu.springcloud.domain.Payment;
import com.mingyu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: PaymentServiceImpl
 * Description:
 * date: 2022/2/1 19:39
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
