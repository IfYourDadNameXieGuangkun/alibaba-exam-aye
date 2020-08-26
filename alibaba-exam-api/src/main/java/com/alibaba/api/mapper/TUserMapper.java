package com.alibaba.api.mapper;

import com.alibaba.api.business.provider.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author aye
 * @since 2020-04-29
 */
@Repository
public interface TUserMapper extends BaseMapper<TUser> {

    TUser findUserByParams(Map<String, Object> params);

    String addUser(TUser s);
}
