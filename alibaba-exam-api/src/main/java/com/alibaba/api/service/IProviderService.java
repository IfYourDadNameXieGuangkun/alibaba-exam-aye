package com.alibaba.api.service;

import com.alibaba.api.business.provider.TUser;

public interface IProviderService {
    TUser findUserByName(String name);
}
