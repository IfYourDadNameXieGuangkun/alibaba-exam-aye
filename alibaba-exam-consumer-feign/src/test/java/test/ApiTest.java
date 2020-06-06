package test;

import com.alibaba.api.client.provider.ProviderClient;
import com.alibaba.consumer.feign.NacosConsumerFeignApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {NacosConsumerFeignApplication.class,ApiTest.class})
@EnableFeignClients(basePackages = {"com.alibaba.api.client"})
public class ApiTest {

    @Autowired
    private ProviderClient providerClient;

    @Test
    public void testFeign01(){
        String test = providerClient.echo("admin");
        System.out.println(test);
    }


}
