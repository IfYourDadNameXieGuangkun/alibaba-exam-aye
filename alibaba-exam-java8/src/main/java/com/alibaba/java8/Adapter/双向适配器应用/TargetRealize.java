package com.alibaba.java8.Adapter.双向适配器应用;

public class TargetRealize implements TwoWayTarget {
    @Override
    public void request() {
        System.out.println("目标代码被调用！");
    }
}
