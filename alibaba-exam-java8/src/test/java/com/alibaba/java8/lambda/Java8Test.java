package com.alibaba.java8.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class Java8Test {


    /**
     * 1.Lambda 表达式匿名内部类实现线程
     */
    @Test
    public void test01(){

        //no-->
        new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
               log.info("Before Java8, too much code for too little to do");
            }
        }).start();

        //java8 yes-->

        new Thread(()-> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }
    /**
     * 1.Collection.sort 排序
     */
    @Test
    public void test02() {

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (Object feature : features) {
            System.out.println(feature);
        }

        features.forEach((n)-> System.out.println(n));

        features.forEach(System.out::println);
    }


    @Test
    public void test03() {

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("startWith J");
        filter(languages,(str)->((String)str).startsWith("J"));

    }
    public static void filter(List<String> names, Predicate condition) {
        for(String  name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }


    @Test
    public void test04() {

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        languages.stream().filter((name)->name.startsWith("J")).filter((name)->name.length()==4).forEach((n)-> System.out.println(n));

    }


}
