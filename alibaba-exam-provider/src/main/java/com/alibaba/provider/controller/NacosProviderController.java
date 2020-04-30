package com.alibaba.provider.controller;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.client.consumer.NacosConsumerFeignControllerFeign;
import com.alibaba.api.client.provider.fallback.NacosProviderControllerFeignFallBack;
import com.alibaba.api.service.ITUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
@Slf4j
public class NacosProviderController extends BaseController {
    @Value("${rediso}")
    private String redis;
    @Value("${mysql0}")
    private String mysql;
    @Autowired
    private ITUserService itUserService;

    @Autowired
    private NacosConsumerFeignControllerFeign nacosConsumerFeignControllerFeign;
    @GetMapping(value = "echo/{name}")
    public String echo(@PathVariable String name){
        log.info("{},{},{},{}",1,2,3,4);
        QueryWrapper<TUser> tUserQueryWrapper = new QueryWrapper<>();
        tUserQueryWrapper.lambda().eq(TUser::getUserName,name);
        TUser user = itUserService.getOne(tUserQueryWrapper);
        Map<String, Object> params = Maps.newHashMap();
        params.put("username",name);
        TUser user1 = itUserService.findUserByParams(params);
        //logger.info("info Provider time is in:{}",System.currentTimeMillis());
        //logger.debug("debug Provider time is in:{}",System.currentTimeMillis());
        logger.error("error Provider time is in:[{}],user is [{}]",System.currentTimeMillis(),user.toString());
        logger.warn("warn Provider time is in:{},user is [{}]",System.currentTimeMillis(),user1.toString());
        return "hello Nacos Discovery "+name+"=="+redis+"==="+mysql;
    }

    @GetMapping(value = "user/get/{name}")
    public TUser testApiFeignAndFallBack(@PathVariable("name") String name){
        QueryWrapper<TUser> tUserQueryWrapper = new QueryWrapper<>();
        tUserQueryWrapper.lambda().eq(TUser::getUserName,name);
        TUser user = itUserService.getOne(tUserQueryWrapper);
        return user;
    }

    @GetMapping(value = "user/list/{name}")
    public String testProviderFeign2Consumer(@PathVariable("name") String name){
        return nacosConsumerFeignControllerFeign.provider2ConsumerFeign(name);
    }

}
