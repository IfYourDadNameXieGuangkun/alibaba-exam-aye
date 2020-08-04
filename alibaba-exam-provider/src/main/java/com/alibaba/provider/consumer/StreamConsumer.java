package com.alibaba.provider.consumer;

import com.alibaba.api.business.provider.TUser;
import com.alibaba.api.mq.StreamSink;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;


@Component
public class StreamConsumer {

    @StreamListener(StreamSink.INPUT1)
    public void receiveMsg(String user){
        TUser user1 = JSONObject.parseObject(user, TUser.class);
        //System.out.println("input1 receive: " + msg.getPayload());
        System.out.println("123123"+user1.getUserName());

    }
}
