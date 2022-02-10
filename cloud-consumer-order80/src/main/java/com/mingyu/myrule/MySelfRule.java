package com.mingyu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MySelfRule
 * Description:
 * date: 2022/2/10 22:22
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
