package com.alibaba.api.service.impl;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.service.IProviderService;
import org.springframework.stereotype.Service;

@Service
public class ProviderService implements IProviderService {


    @Override
    public TUser findUserByName(String name) {
        return null;
    }
}
