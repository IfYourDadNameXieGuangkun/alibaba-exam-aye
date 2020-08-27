package com.alibaba.java8.ChainOfResponsibility.责任链模式实现;

public class HandlerTest {
    public static void main(String[] args) {
        //组装责任链
        Handler handlerA=new CurrentHandlerA();
        Handler handlerB=new CurrentHandlerB();
        handlerA.setNext(handlerB);
        //提交请求
        handlerA.handleRequest("B");
    }
}
