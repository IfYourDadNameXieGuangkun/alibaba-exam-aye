package com.alibaba.java8.Observer.模式应用实例;

public class RMBRateTest {

    public static void main(String[] args) {
        Rate rate=new RMBRate();
        Company watcher1=new ImportCompany();
        Company watcher2=new ExportCompany();
        rate.add(watcher1);
        rate.add(watcher2);
        rate.change(10);
        rate.change(-9);
    }
}
