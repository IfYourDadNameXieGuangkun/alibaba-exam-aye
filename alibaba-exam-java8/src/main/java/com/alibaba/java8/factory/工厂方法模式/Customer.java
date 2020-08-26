package com.alibaba.java8.factory.工厂方法模式;


public class Customer {
    public static void main(String[] args) {
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        BMW BMW320 = factoryBMW320.createBMW();

        FactoryBMW530 factoryBMW530 = new FactoryBMW530();
        BMW BMW530 = factoryBMW530.createBMW();
    }
}
