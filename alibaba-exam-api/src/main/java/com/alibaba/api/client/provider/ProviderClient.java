package com.alibaba.api.client.provider;
import com.alibaba.api.client.provider.fallback.ProviderClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * function:1.供其他微服务调用nacos-provider服务,
 * 2."nacos-provider" 为provider服务的应用名称,这个在nacos配置文件中配置ApplicationName="nacos-provider"
 * 3.这个Client对应的Controller是provider服务中的 AcceptFeign2ProviderController
 */
@FeignClient(value = "nacos-provider",fallback = ProviderClientFallBack.class,path = "cliProvider")
public interface ProviderClient {
    @GetMapping(value = "echo/{name}")
    String echo(@PathVariable String name);
}
