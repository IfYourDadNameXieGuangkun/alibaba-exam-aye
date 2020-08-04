package com.alibaba.api.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StreamSource {

    String OUTPUT1= "output1";
    @Output(StreamSource.OUTPUT1)
    MessageChannel output1();

    String OUTPUT2= "output2";
    @Output(StreamSource.OUTPUT2)
    MessageChannel output2();

}
