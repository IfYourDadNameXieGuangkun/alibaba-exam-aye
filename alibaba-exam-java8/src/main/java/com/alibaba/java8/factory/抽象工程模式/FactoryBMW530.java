package com.alibaba.java8.factory.抽象工程模式;


public class FactoryBMW530 implements AbstractFactory {

    @Override
    public Engine createEngine() {
        return new EngineB();
    }

    @Override
    public Aircondition createAircondition() {
        return new AirconditionB();
    }
}
