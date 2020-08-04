package com.alibaba.api.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface StreamSink {

    String INPUT1= "input1";
    @Input(StreamSink.INPUT1)
    SubscribableChannel input1();

    String INPUT2= "input2";
    @Input(StreamSink.INPUT2)
    SubscribableChannel input2();
}
