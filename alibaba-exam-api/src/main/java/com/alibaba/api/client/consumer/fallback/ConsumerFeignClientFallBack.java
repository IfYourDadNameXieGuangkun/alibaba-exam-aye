package com.alibaba.api.client.consumer.fallback;


import com.alibaba.api.client.consumer.ConsumerFeignClient;
import com.alibaba.api.common.controller.BaseController;
import com.alibaba.api.common.utils.Result;
import org.springframework.stereotype.Component;

/**
 * function:1.供其他微服务调用Consumer-Feign服务,
 * 2."nacos-consumer-feign" 为Consumer-Feign服务的应用名称,nacos配置文件中配置
 */

@Component
public class ConsumerFeignClientFallBack extends BaseController  implements ConsumerFeignClient {

    @Override
    public Result provider2Feign(String name) {
        logger.info("ConsumerFeignClientFallBack 熔断后调用[{}]",name);
        return Result.FAIL();
    }
}
