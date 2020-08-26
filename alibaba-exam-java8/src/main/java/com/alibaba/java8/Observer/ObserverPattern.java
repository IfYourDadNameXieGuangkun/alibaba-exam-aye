package com.alibaba.java8.Observer;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new CurrentSubject();
        Observer currentObserverA = new CurrentObserverA();
        Observer currentObserverB = new CurrentObserverB();
        subject.add(currentObserverA);
        subject.add(currentObserverB);
        subject.notifyObserver();

    }
}
