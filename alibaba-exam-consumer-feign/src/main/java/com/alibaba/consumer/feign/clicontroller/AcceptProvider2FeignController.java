package com.alibaba.consumer.feign.clicontroller;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.common.controller.BaseController;
import com.alibaba.api.common.utils.Result;
import com.alibaba.api.config.redis.RedisUtil;
import com.alibaba.api.service.ITUserService;
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
@RequestMapping("consumerFeign")
public class AcceptProvider2FeignController extends BaseController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ITUserService itUserService;

    @GetMapping("feign/user/get/{name}")
    public Result provider2Feign(@PathVariable("name") String name){
        QueryWrapper<TUser> tUserQueryWrapper = new QueryWrapper<>();
        tUserQueryWrapper.lambda().eq(TUser::getUserName,name);
        TUser user = itUserService.getOne(tUserQueryWrapper);
        logger.info(user.getUserName());
        redisUtil.set("consumerFeigns",name);
        return Result.SUCCESS();
    }
}