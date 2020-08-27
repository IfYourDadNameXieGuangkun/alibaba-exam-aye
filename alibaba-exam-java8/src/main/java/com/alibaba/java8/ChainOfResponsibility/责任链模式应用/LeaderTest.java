package com.alibaba.java8.ChainOfResponsibility.责任链模式应用;

public class LeaderTest {

    public static void main(String[] args) {
        //组装责任链
        Leader classAdviser=new ClassAdviser();
        Leader departmentHead=new DepartmentHead();
        Leader dean=new Dean();
        Leader deanOfStudies = new DeanOfStudies();
        classAdviser.setNext(departmentHead);
        departmentHead.setNext(dean);
        dean.setNext(deanOfStudies);
        classAdviser.handleRequest(1);
        classAdviser.handleRequest(4);
        classAdviser.handleRequest(8);
        classAdviser.handleRequest(11);
    }
}
