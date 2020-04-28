package com.alibaba.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class NacosConsumerController extends BaseController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/{msg}")
    public String echo (@PathVariable String msg){
        /**
         * no.1 传统方法调用provider
         */
        logger.info("info-consumer time is in {}",System.currentTimeMillis());
        logger.error("error-consumer time is in {}",System.currentTimeMillis());
        logger.debug("debug-consumer time is in {}",System.currentTimeMillis());
        logger.warn("warn-consumer time is in {}",System.currentTimeMillis());
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),msg);
        return restTemplate.getForObject(url,String.class);

    }

    /**
     * Gateway AuthFilter Test
     * @param msg
     * @return
     */
    @GetMapping(value = "/authFilter/{msg}")
    public String authFilterTest (@PathVariable String msg){
       logger.info("AuthFilter Come in");
        return "AuthFilter Test Success "+msg;
    }
}
