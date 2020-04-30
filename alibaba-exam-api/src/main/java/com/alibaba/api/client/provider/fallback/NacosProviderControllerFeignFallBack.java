package com.alibaba.api.client.provider.fallback;


import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.client.provider.NacosProviderControllerFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class NacosProviderControllerFeignFallBack  implements NacosProviderControllerFeign  {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public TUser testApiFeignAndFallBack(String name) {
        logger.info("Feign Api Fall Back Success name [{}]",name);
        return null;
    }
}
