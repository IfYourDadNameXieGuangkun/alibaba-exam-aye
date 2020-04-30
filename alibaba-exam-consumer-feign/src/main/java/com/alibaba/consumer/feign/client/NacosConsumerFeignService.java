//package com.alibaba.consumer.feign.client;
//
//
//
//import com.alibaba.consumer.feign.client.fallback.NacosConsumerFeignServiceFallBack;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
///**
// * TODO 作废(1) 但保留开发痕迹
// *  Feign服务转移到公共Api项目中调用,详情参照Api项目中的client目录服务
// */
//@FeignClient(value = "nacos-provider",fallback = NacosConsumerFeignServiceFallBack.class)
//public interface NacosConsumerFeignService {
//
//    @GetMapping(value = "/echo/{message}" )
//    String echo(@PathVariable("message") String message);
//}
