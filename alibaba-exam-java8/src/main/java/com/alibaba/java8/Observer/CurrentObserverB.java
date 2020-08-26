package com.alibaba.java8.Observer;

/**
 * 具体观察者B
 */
public class CurrentObserverB implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者B作出反应！");
    }
}
