package com.alibaba.api.client.consumer.fallback;


import com.alibaba.api.client.consumer.NacosConsumerFeignControllerFeign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class NacosConsumerFeignControllerFeignFallBack implements NacosConsumerFeignControllerFeign {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String provider2ConsumerFeign(String name) {
        return "NacosConsumerFeignControllerFeignFallBack"+"=="+name;
    }
}
