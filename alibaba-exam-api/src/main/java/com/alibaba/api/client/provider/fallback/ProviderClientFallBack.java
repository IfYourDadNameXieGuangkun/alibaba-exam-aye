package com.alibaba.api.client.provider.fallback;

import com.alibaba.api.client.provider.ProviderClient;
import org.springframework.stereotype.Component;

@Component
public class ProviderClientFallBack implements ProviderClient {
    @Override
    public String echo(String name) {
        return "feign2provider==fallback"+"["+name+"]";
    }
}
