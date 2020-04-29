package com.alibaba.api.service;


import com.alibaba.api.business.provider.TUser;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author aye
 * @since 2020-04-29
 */
public interface ITUserService extends IService<TUser> {


    TUser findUserByParams(Map<String, Object> params);
}
