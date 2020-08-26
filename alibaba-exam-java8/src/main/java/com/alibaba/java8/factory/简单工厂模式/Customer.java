package com.alibaba.java8.factory.简单工厂模式;

public class Customer {
    public static void main(String[] args) {
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw530 = factory.createBMW(530);

    }
}
