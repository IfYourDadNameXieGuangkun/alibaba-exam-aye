package com.alibaba.java8.Adapter.双向适配器应用;

public class TwoWayAdapterTest {
    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdaptee adaptee = new AdapteeRealize();
        TwoWayAdaptee adapteeTarget = new TwoWayAdapter(adaptee);
        adapteeTarget.specificRequest();

        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");

        TwoWayTarget target = new TargetRealize();
        TwoWayTarget targetTarget = new TwoWayAdapter(target);
        targetTarget.request();
    }
}
