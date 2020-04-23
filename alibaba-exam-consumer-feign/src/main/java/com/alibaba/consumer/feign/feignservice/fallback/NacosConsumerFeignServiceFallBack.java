package com.alibaba.consumer.feign.feignservice.fallback;

import com.alibaba.consumer.feign.feignservice.NacosConsumerFeignService;
import org.springframework.stereotype.Component;


@Component
public class NacosConsumerFeignServiceFallBack implements NacosConsumerFeignService {
    @Override
    public String echo(String message) {
        return "msg: "+message+" fallBack online";
    }
}
