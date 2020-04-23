package com.alibaba.consumer.feign.controller;

import com.alibaba.consumer.feign.feignService.NacosConsumerFeighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NacosConsumerFeighController {

    @Autowired
    private NacosConsumerFeighService nacosConsumerFeighService;

    @GetMapping("/feigh/{msg}")
    public String echo(@PathVariable String msg){

        return nacosConsumerFeighService.echo(msg);
    }
}
