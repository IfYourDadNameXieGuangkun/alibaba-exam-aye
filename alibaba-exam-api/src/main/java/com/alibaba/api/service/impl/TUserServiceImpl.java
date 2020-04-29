package com.alibaba.api.service.impl;


import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.mapper.TUserMapper;
import com.alibaba.api.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author aye
 * @since 2020-04-29
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
