package com.alibaba.java8.factory.简单工厂模式;

public class Factory {
    public BMW createBMW(int type) {
        switch (type) {

            case 320:
                return new BMW320();

            case 530:
                return new BMW530();

            default:
                break;
        }
        return null;
    }
}
