package com.alibaba.consumer.feign.client;



import com.alibaba.consumer.feign.client.fallback.NacosConsumerFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider",fallback = NacosConsumerFeignServiceFallBack.class)
public interface NacosConsumerFeignService {

    @GetMapping(value = "/echo/{message}" )
    String echo(@PathVariable("message") String message);
}
