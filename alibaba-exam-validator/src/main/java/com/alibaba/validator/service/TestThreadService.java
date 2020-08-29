package com.alibaba.validator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @ClassName TestThreadService
 * @Description 测试线程
 * @Author Aye
 * @Date 2020/8/29 11:49
 * @Version 1.0
 */
@Service
public class TestThreadService {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    // 发送提醒短信 1
    @PostConstruct // 加上该注解项目启动时就执行一次该方法
    @Async("taskExecutor")
    public void sendMessage1() throws InterruptedException {
        log.info("发送短信方法---- 1   执行开始");
        Thread.sleep(5000); // 模拟耗时
        log.info("发送短信方法---- 1   执行结束");
    }

    // 发送提醒短信 2
    @PostConstruct // 加上该注解项目启动时就执行一次该方法
    @Async("taskExecutor")
    public void sendMessage2() throws InterruptedException {

        log.info("发送短信方法---- 2   执行开始");
        Thread.sleep(2000); // 模拟耗时
        log.info("发送短信方法---- 2   执行结束");
    }
}