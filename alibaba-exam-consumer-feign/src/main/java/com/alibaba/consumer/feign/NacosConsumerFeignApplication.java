package com.alibaba.consumer.feign;

import com.alibaba.api.mq.StreamSink;
import com.alibaba.api.mq.StreamSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.alibaba.api.client"})
@ComponentScan(basePackages = {"com.alibaba"})
@EnableBinding({StreamSink.class, StreamSource.class})
public class NacosConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerFeignApplication.class,args);
    }
}
