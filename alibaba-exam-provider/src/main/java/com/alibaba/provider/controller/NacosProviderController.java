package com.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController extends BaseController {
    @Value("${rediso}")
    private String redis;
    @Value("${mysql0}")
    private String mysql;
    @GetMapping(value = "echo/{message}")
    public String echo(@PathVariable String message){
        //logger.info("info Provider time is in:{}",System.currentTimeMillis());
        //logger.debug("debug Provider time is in:{}",System.currentTimeMillis());
        logger.error("error Provider time is in:{}",System.currentTimeMillis());
        //logger.warn("warn Provider time is in:{}",System.currentTimeMillis());
        return "hello Nacos Discovery "+message+"=="+redis+"==="+mysql;
    }

}
