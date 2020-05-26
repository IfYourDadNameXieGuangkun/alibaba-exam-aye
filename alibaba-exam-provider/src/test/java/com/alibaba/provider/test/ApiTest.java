package com.alibaba.provider.test;

import com.alibaba.api.client.consumer.ConsumerFeignClient;
import com.alibaba.api.client.consumer.NacosConsumerFeignControllerFeign;
import com.alibaba.api.common.utils.Result;
import com.alibaba.provider.NacosProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {NacosProviderApplication.class,ApiTest.class})
@EnableFeignClients(basePackages = {"com.alibaba.api.client"})
public class ApiTest {

    @Autowired
    private NacosConsumerFeignControllerFeign nacosConsumerFeignControllerFeign;

    @Autowired
    private ConsumerFeignClient consumerFeignClient;
    @Test
    public void testFeign01(){
        String test = nacosConsumerFeignControllerFeign.provider2ConsumerFeign("test");
        System.out.println(test);
    }

    @Test
    public void testFeign02(){
        Result test = consumerFeignClient.provider2Feign("admin");
        System.out.println(test);
    }

}
