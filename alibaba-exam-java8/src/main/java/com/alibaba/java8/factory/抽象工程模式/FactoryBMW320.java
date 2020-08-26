package com.alibaba.java8.factory.抽象工程模式;


public class FactoryBMW320 implements AbstractFactory {

    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public Aircondition createAircondition() {
        return new AirconditionA();
    }
}
