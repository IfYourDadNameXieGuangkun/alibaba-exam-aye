package com.alibaba.java8;


import com.alibaba.java8.Observer.Spring中的观察者模式.MyEvent;
import com.alibaba.java8.Observer.Spring中的观察者模式.MyPublisher;
import com.alibaba.java8.Observer.实战观察者模式.LoginEvent;
import com.alibaba.java8.Observer.实战观察者模式.LoginPublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("local")
@Slf4j
public class 观察者模式测试 {

    @Autowired
    private MyPublisher myPublisher;

    @Autowired
    private LoginPublisher loginPublisher;
    @Autowired
    private MyEvent myEvent;

    @Test
    public void Spring中观察者模式测试() {
        myPublisher.publisherEvent(myEvent);
    }

    @Test
    public void 实战观察者模式() {
        loginPublisher.publisherEvent(new LoginEvent(this,"阿夜"));
    }
}
