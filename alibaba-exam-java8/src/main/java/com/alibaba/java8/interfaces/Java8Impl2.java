package com.alibaba.java8.interfaces;

import org.springframework.stereotype.Component;

@Component
public class Java8Impl2 implements Java8Interface1 {

    private Integer order =1;
    @Override
    public void doFilter() {
        System.out.println("Java8Impl1");
    }

    @Override
    public int getOrder() {
        return order;
    }
}
