package com.alibaba.spring.conditionassemb;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Conditional(MagicCondition.class)//MagicCondition条件创建Bean,若false 则不创建Bean

public class MagicBean implements MagicInterface {
    @Override
    public void magic() {
        System.out.println("magic");
    }
}
