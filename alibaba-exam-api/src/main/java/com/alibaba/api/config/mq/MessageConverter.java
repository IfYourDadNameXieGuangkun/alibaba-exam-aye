package com.alibaba.api.config.mq;

import com.alibaba.fastjson.support.spring.messaging.MappingFastJsonMessageConverter;
import org.springframework.cloud.stream.annotation.StreamMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConverter {

    @Bean
    @StreamMessageConverter
    public MappingFastJsonMessageConverter mappingFastJsonMessageConverter() {
        return new MappingFastJsonMessageConverter();
    }
}
