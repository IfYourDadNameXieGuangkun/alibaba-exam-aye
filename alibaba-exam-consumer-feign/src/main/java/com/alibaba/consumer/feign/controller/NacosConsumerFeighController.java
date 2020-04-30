package com.alibaba.consumer.feign.controller;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.client.provider.NacosProviderControllerFeign;
import com.alibaba.consumer.feign.client.NacosConsumerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NacosConsumerFeighController {

    @Autowired
    private NacosConsumerFeignService nacosConsumerFeighService;

    @Autowired(required = true)
    private NacosProviderControllerFeign nacosProviderControllerFeign;

    @GetMapping("/feign/{msg}")
    public String echo(@PathVariable String msg){

        return nacosConsumerFeighService.echo(msg);
    }

    @GetMapping("/consumer/feign/provider/{msg}")
    public TUser consumerFeignProvider(@PathVariable String msg){
        return nacosProviderControllerFeign.testApiFeignAndFallBack(msg);
    }
}
