package com.alibaba.api.client.consumer;



import com.alibaba.api.client.consumer.fallback.NacosConsumerFeignControllerFeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * path对应 @RequestMapping("aye") 使用起来方便
 */
@FeignClient(value = "nacos-consumer-feign",fallback = NacosConsumerFeignControllerFeignFallBack.class,path = "aye")
public interface NacosConsumerFeignControllerFeign {

    @GetMapping("/feign/provider/feign/consumer/{name}")
    String provider2ConsumerFeign(@PathVariable("name") String name);
}