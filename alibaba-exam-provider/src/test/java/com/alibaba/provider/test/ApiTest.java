package com.alibaba.provider.test;

import com.alibaba.provider.NacosProviderApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {NacosProviderApplication.class,ApiTest.class})
public class ApiTest {

}
