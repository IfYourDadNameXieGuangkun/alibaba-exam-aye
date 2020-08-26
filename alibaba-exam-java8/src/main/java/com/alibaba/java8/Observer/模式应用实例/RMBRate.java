package com.alibaba.java8.Observer.模式应用实例;

public class RMBRate extends Rate {
    @Override
    public void change(int number) {
        for(Company obs:companys)
        {
            ((Company)obs).response(number);
        }
    }
}
