package com.alibaba.consumer.feign.controller;


import com.alibaba.api.client.provider.ProviderClient;
import com.alibaba.api.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Feign2ProviderController {

    @Autowired
    private ProviderClient providerClient;
    @GetMapping(value = "/feign2provider/{name}")
    public Result Provider2Feign(@PathVariable String name){
        System.out.println(name);
        String result = providerClient.echo(name);
        System.out.println(result);
        return Result.SUCCESS(result);

    }
}
