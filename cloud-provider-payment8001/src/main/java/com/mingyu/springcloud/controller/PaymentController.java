package com.mingyu.springcloud.controller;

import com.mingyu.springcloud.domain.CommonResult;
import com.mingyu.springcloud.domain.Payment;
import com.mingyu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: PaymentController
 * Description:
 * date: 2022/2/1 19:44
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(path = "/payment-obj")
    public CommonResult<Integer> createPayment(@RequestBody Payment payment){
        Integer result = paymentService.create(payment);
        log.info("createPayment result is {}", result);
        if (result > 0){
            return new CommonResult<>(200, "添加payment成功" + serverPort, result);
        } else {
            return new CommonResult<>(444, "添加payment失败" + serverPort, null);
        }
    }

    @GetMapping(path = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("getPaymentById result is {}", payment);
        if (payment != null){
            return  new CommonResult<>(200, "查询payment成功" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "查询payment失败" + serverPort, null);
        }
    }

    @GetMapping(path = "/discovery-client")
    public Object discoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services){
            log.info("***** element*** " + service);
        }
        List<ServiceInstance> discoveryClientInstances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYTMENT-SERVER");
        for (ServiceInstance instance : discoveryClientInstances){
            log.info(instance.getServiceId()+ "\t" + instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(path = "/timeout")
    public String timeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
