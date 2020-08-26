package com.alibaba.java8.Observer.实战观察者模式;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener implements ApplicationListener<LoginEvent> {
    @Override
    public void onApplicationEvent(LoginEvent loginEvent) {
        String userName = loginEvent.getUserName();
        System.out.println("发送邮件用户名:["+userName+"]");
    }
}
