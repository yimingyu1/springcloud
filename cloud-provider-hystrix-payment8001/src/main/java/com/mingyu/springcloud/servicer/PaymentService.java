package com.mingyu.springcloud.servicer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
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

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_timeOut(Integer id){
        int timeoutSecond = 5;
        try {
            TimeUnit.SECONDS.sleep(timeoutSecond);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK, id：" + id + "timeout：" + timeoutSecond;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK, id：" + id + "timeout：" + "o(╥﹏╥)o";
    }

    @HystrixCommand(fallbackMethod = "paymentBreakDown", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  //  失败率达到多少后跳闸

    })
    public String paymentBreak(Integer id){
        if (id < 0){
            throw new RuntimeException("id不能小于0");
        }
        return Thread.currentThread().getName() + "success"+ UUID.randomUUID().toString();
    }

    public String paymentBreakDown(Integer id){
        return "lajibadao ba ";
    }
}
