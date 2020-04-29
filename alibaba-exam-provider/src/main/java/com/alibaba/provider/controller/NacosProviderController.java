package com.alibaba.provider.controller;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.service.ITUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ITUserService itUserService;
    @GetMapping(value = "echo/{name}")
    public String echo(@PathVariable String name){

        QueryWrapper<TUser> tUserQueryWrapper = new QueryWrapper<>();
        tUserQueryWrapper.lambda().eq(TUser::getUserName,name);
        TUser user = itUserService.getOne(tUserQueryWrapper);
        //logger.info("info Provider time is in:{}",System.currentTimeMillis());
        //logger.debug("debug Provider time is in:{}",System.currentTimeMillis());
        logger.error("error Provider time is in:[{}],user is [{}]",System.currentTimeMillis(),user.toString());
        //logger.warn("warn Provider time is in:{}",System.currentTimeMillis());
        return "hello Nacos Discovery "+name+"=="+redis+"==="+mysql;
    }

}
