package com.alibaba.api.client.provider;


import com.alibaba.api.business.provider.TUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider")
public interface NacosProviderControllerFeign {
    @GetMapping(value = "user/get/{name}")
    TUser testApiFeignAndFallBack(@PathVariable("name") String name);
}
