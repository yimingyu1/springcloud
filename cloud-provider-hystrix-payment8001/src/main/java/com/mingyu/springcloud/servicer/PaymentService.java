package com.mingyu.springcloud.servicer;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: PaymentService
 * Description:
 * date: 2022/2/13 22:24
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK, id：" + id;
    }

    public String paymentInfo_timeOut(Integer id){
        int timeoutSecond = 3;
        try {
            TimeUnit.SECONDS.sleep(timeoutSecond);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK, id：" + id + "timeout：" + timeoutSecond;
    }
}
