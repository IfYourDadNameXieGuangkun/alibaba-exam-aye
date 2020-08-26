package com.alibaba.java8.Observer.实战观察者模式;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LogsListener implements ApplicationListener<LoginEvent> {
    @Override
    public void onApplicationEvent(LoginEvent loginEvent) {
        String userName = loginEvent.getUserName();
        System.out.println("日志记录登录用户名:["+userName+"]");
    }
}
