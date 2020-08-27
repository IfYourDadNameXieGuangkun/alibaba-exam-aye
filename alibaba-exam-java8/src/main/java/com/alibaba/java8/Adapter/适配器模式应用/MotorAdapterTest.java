package com.alibaba.java8.Adapter.适配器模式应用;

public class MotorAdapterTest {
    public static void main(String[] args) {
        System.out.println("适配器模式测试：");
        Motor motor = (Motor)ReadXML.getObject();
        motor.drive();
    }
}
