package com.alibaba.java8.Adapter.适配器模式应用;

public class OpticalAdapter implements Motor {

    private OpticalMotor omotor;

    public OpticalAdapter() {
        omotor = new OpticalMotor();
    }

    @Override
    public void drive() {
        omotor.electricDrive();
    }
}
