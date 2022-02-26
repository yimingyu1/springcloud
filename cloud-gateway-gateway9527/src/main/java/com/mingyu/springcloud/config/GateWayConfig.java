package com.mingyu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: GateWayConfig
 * Description:
 * date: 2022/2/26 11:46
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route( r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .build();
    }
}
