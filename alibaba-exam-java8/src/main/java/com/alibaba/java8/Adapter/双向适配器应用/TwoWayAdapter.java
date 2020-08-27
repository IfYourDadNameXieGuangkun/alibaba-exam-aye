package com.alibaba.java8.Adapter.双向适配器应用;

public class TwoWayAdapter implements TwoWayAdaptee, TwoWayTarget {

    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;

    public TwoWayAdapter(TwoWayTarget target) {
        this.target = target;
    }

    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void specificRequest() {
        adaptee.specificRequest();
    }

    @Override
    public void request() {
        target.request();
    }
}
