package com.alibaba.consumer.feign.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.alibaba")
@MapperScan(basePackages = {"com.alibaba.api.**.mapper"})
public class MyBatisPlusConfig {

        @Bean
        public PaginationInterceptor paginationInterceptor() {
            return new PaginationInterceptor();
        }


}
