package com.alibaba.java8.Observer.实战观察者模式;

import org.springframework.context.ApplicationEvent;

/**
 * 1.定义登录事件,继承ApplicationEvent 并重写对应的构造方法
 */

public class LoginEvent extends ApplicationEvent {
    private String userName;


    public LoginEvent(Object source) {
        super(source);
    }

    public LoginEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

}
