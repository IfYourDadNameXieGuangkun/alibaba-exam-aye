package com.alibaba.java8.Observer.Spring中的观察者模式;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


@Component
public class MyEvent extends ApplicationEvent {


    public MyEvent(ApplicationContext source) {
        super(source);
        System.out.println("MyEvent 构造器执行");
    }

    public void echo() {
        System.out.println("模拟业务逻辑执行");
    }


}
