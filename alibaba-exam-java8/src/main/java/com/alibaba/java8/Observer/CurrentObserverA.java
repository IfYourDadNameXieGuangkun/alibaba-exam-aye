package com.alibaba.java8.Observer;

/**
 * 具体观察者A
 */
public class CurrentObserverA implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者A作出反应");
    }
}
