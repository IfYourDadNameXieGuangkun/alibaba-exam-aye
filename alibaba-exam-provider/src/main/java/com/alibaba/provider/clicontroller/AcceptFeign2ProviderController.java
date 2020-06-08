package com.alibaba.provider.clicontroller;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.common.controller.BaseController;
import com.alibaba.api.service.ITUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


/**
 * 此Controller 提供给外部服务调用
 */
@RestController
@Slf4j
@RequestMapping("cliProvider")
public class AcceptFeign2ProviderController extends BaseController {
    @Value("${rediso}")
    private String redis;
    @Value("${mysql0}")
    private String mysql;
    @Autowired
    private ITUserService itUserService;

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


}
