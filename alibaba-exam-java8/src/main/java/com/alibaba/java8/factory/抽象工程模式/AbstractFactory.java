package com.alibaba.java8.factory.抽象工程模式;

public interface AbstractFactory {
    //制造发动机
    public Engine createEngine();
    //制造空调
    public Aircondition createAircondition();
}
