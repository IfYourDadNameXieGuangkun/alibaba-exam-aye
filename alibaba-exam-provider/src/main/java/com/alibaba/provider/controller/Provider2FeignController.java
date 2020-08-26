package com.alibaba.provider.controller;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.client.consumer.ConsumerFeignClient;
import com.alibaba.api.common.controller.BaseController;
import com.alibaba.api.common.enums.ResultCode;
import com.alibaba.api.common.utils.Email.MailService;
import com.alibaba.api.common.utils.Result;
import com.alibaba.api.config.redis.RedisUtil;
import com.alibaba.api.service.ITUserService;
import com.alibaba.api.mq.StreamSource;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * function:实现服务之间的调用
 * (1)调用consumer-feign 服务--> [Provider2Feign方法]
 */
@RestController
@RequestMapping("provider")
@Slf4j
public class Provider2FeignController extends BaseController {

    @Value("${rediso}")
    private String redis;
    @Value("${mysql0}")
    private String mysql;

    @Autowired
    private ITUserService userService;

    @Autowired
    private ConsumerFeignClient consumerFeignClient;

    @Autowired
    private MailService mailService;

//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private StreamSource source;

    @Autowired
    private RedisUtil redisUtil;
    @GetMapping(value = "/provider2feign/{name}")
    public Result Provider2Feign(@PathVariable String name){
        Result result = consumerFeignClient.provider2Feign(name);
        int resultCode = result.getResultCode();
        if (resultCode == ResultCode.FAIL){
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        name = redisUtil.get("consumerFeigns")+"";
        params.put("username",name);
        TUser user = userService.findUserByParams(params);
        mailService.sendSimpleMail("baiwei@lppz.com","美国-五角大楼-provider",name);
        return Result.SUCCESS(user);
    }

    @GetMapping(value = "/mq/{msg}")
    public Result sendMq(@PathVariable String msg){
        List<TUser> list = userService.list();
        list.forEach(user->{
            source.output2().send(MessageBuilder.withPayload(user).build());
        });

        //source.output1().send(MessageBuilder.withPayload(msg).build());
        return Result.SUCCESS(msg);
    }
    @PostMapping(value = "/user/add")
    public Result userAdd(@RequestBody TUser user){

        return Result.SUCCESS(userService.addUser(user));
    }

}
