package com.alibaba.consumer.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暴露Feign服务调用接口
 */
@RestController
@RequestMapping("aye")
public class NacosCFController {

    @GetMapping("feign/provider/feign/consumer/{name}")
    public String provider2ConsumerFeign(@PathVariable("name") String name){
        return name;
    }
}
