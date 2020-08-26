package com.alibaba.java8.Observer.Spring中的观察者模式;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListenerB implements ApplicationListener<MyEvent> {

    @EventListener
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("MyListenerB");
        myEvent.echo();
    }
}
