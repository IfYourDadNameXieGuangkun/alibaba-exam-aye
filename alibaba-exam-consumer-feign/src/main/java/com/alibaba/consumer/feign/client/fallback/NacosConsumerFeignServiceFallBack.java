package com.alibaba.consumer.feign.client.fallback;

import com.alibaba.consumer.feign.client.NacosConsumerFeignService;
import org.springframework.stereotype.Component;


@Component
public class NacosConsumerFeignServiceFallBack implements NacosConsumerFeignService {
    @Override
    public String echo(String message) {
        return "msg: "+message+" fallBack online";
    }
}
