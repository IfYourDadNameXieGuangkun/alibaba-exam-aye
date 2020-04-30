//package com.alibaba.consumer.feign.client.fallback;
//
//import com.alibaba.consumer.feign.client.NacosConsumerFeignService;
//import org.springframework.stereotype.Component;
//
//
///**
// * TODO 作废(2) 但保留开发痕迹
// *  Feign服务转移到公共Api项目中调用,详情参照Api项目中的client目录服务
// */
//@Component
//public class NacosConsumerFeignServiceFallBack implements NacosConsumerFeignService {
//    @Override
//    public String echo(String message) {
//        return "msg: "+message+" fallBack online";
//    }
//}
