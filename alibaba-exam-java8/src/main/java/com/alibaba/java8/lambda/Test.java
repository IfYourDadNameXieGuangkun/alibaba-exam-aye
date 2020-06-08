package com.alibaba.java8.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        //test01();
        test02();
    }


    //匿名内部类使用Lambda表达式代替
    private static void test01(){
        //old before java8
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before java 8 Lambda Expression");
            }
        }).start();

        new Thread(()-> System.out.println("In java 8 Lambda Expression")).start();
    }



    private static void test02(){
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
    }


}
