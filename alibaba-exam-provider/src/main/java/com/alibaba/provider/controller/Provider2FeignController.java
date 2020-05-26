package com.alibaba.provider.controller;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.client.consumer.ConsumerFeignClient;
import com.alibaba.api.common.controller.BaseController;
import com.alibaba.api.common.enums.ResultCode;
import com.alibaba.api.common.utils.Result;
import com.alibaba.api.service.ITUserService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * function:实现服务之间的调用
 * (1)调用consumer-feign 服务--> [Provider2Feign方法]
 */
@RestController
@RequestMapping("provider")
public class Provider2FeignController extends BaseController {

    @Autowired
    private ITUserService userService;

    @Autowired
    private ConsumerFeignClient consumerFeignClient;


    @GetMapping(value = "/provider2feign/{name}")
    public Result Provider2Feign(@PathVariable String name){
        Result result = consumerFeignClient.provider2Feign(name);
        int resultCode = result.getResultCode();
        if (resultCode == ResultCode.FAIL){
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("username",name);
        TUser user = userService.findUserByParams(params);
        return Result.SUCCESS(user);
    }

}
