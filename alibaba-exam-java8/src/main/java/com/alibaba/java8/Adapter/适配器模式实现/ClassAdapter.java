package com.alibaba.java8.Adapter.适配器模式实现;

/**
 * 类适配器类
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}
