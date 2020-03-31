package com.alibaba.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController {
    @GetMapping(value = "echo/{message}")
    public String echo(@PathVariable String message){
        return "hello Nacos Discovery"+message;
    }

}
