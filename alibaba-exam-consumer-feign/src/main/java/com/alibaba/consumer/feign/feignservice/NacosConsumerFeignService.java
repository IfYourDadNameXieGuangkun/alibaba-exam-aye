package com.alibaba.consumer.feign.feignservice;



import com.alibaba.consumer.feign.feignservice.fallback.NacosConsumerFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider",fallback = NacosConsumerFeignServiceFallBack.class)
public interface NacosConsumerFeignService {

    @GetMapping(value = "/echo/{message}" )
    String echo(@PathVariable("message") String message);
}
