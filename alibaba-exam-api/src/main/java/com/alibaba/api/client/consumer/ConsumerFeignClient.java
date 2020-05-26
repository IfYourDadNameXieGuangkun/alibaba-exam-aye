package com.alibaba.api.client.consumer;


import com.alibaba.api.client.consumer.fallback.ConsumerFeignClientFallBack;
import com.alibaba.api.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * function:1.供其他微服务调用Consumer-Feign服务,
 * 2."nacos-consumer-feign" 为Consumer-Feign服务的应用名称,这个在nacos配置文件中配置ApplicationName="nacos-consumer-feign"
 * 3.这个Client对应的Consumer-Feign服务中的 AcceptProvider2FeignController
 */
@FeignClient(value = "nacos-consumer-feign",fallback = ConsumerFeignClientFallBack.class,path = "consumerFeign")
public interface ConsumerFeignClient {
    @GetMapping(value = "feign/user/get/{name}")
    Result provider2Feign(@PathVariable("name") String name);
}
