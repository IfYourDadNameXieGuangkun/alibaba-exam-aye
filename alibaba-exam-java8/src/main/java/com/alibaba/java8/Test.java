package com.alibaba.java8;

import com.alibaba.java8.interfaces.Formula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        //test01();
        test03();
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


    private static void test03(){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 1000);
            }
        };

        double calculate = formula.calculate(2);
        double calculate2 = formula.sqrt(2);
        System.out.println(calculate+":"+calculate2);
    }





}
