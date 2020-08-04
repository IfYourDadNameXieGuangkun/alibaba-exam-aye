package com.alibaba.java8.interfaces;

public interface Formula {
    double calculate(int a);

    /**
     * 使用default 关键字 实现扩展方法
     * @param a
     * @return
     */
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
