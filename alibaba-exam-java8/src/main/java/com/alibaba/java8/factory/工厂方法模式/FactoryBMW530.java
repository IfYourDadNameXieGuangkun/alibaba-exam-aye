package com.alibaba.java8.factory.工厂方法模式;

public class FactoryBMW530 implements FactoryBMW {
    @Override
    public BMW createBMW() {
        return new BMW530();
    }
}
