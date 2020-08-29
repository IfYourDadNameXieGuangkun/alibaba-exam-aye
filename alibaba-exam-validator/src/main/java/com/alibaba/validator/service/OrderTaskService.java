package com.alibaba.validator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderTaskService
 * @Description TODO
 * @Author Aye
 * @Date 2020/8/29 14:07
 * @Version 1.0
 */
@Service
public class OrderTaskService {
    @Autowired
    private TestThreadService testThreadService;

    // 订单处理任务
    public void orderTask() throws InterruptedException {

        this.cancelOrder(); // 取消订单
        testThreadService.sendMessage1(); // 发短信的方法   1
        testThreadService.sendMessage2(); // 发短信的方法  2

    }

    // 取消订单
    public void cancelOrder() throws InterruptedException {
        System.out.println("取消订单的方法执行------开始");
        System.out.println("取消订单的方法执行------结束 ");
    }
}