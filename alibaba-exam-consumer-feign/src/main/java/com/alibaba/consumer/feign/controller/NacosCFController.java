package com.alibaba.consumer.feign.controller;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.common.controller.BaseController;
import com.alibaba.api.config.redis.RedisUtil;
import com.alibaba.api.service.ITUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 暴露Feign服务调用接口
 */
@RestController
@RequestMapping("aye")
public class NacosCFController extends BaseController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ITUserService itUserService;

    @GetMapping("feign/provider/feign/consumer/{name}")
    public String provider2ConsumerFeign(@PathVariable("name") String name){
        QueryWrapper<TUser> tUserQueryWrapper = new QueryWrapper<>();
        tUserQueryWrapper.lambda().eq(TUser::getUserName,name);
        TUser user = itUserService.getOne(tUserQueryWrapper);
        System.out.println(JSONObject.toJSONString(user));
        redisUtil.set("redis-nacos","mysql-redis");
        return name;
    }
}