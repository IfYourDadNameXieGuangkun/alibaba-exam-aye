package com.alibaba.provider.test;

import com.alibaba.provider.NacosProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {NacosProviderApplication.class,ApiTest.class})
@EnableFeignClients(basePackages = {"com.alibaba.api.client"})
public class Java8Test {

    //lambda表达式 案例一
    @Test
    public void test01(){

        //no-->
        new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        //java8 yes-->

        new Thread(()-> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }
}
