package com.alibaba.consumer.feign.feignService;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider")
public interface NacosConsumerFeighService {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable("message") String message);
}
