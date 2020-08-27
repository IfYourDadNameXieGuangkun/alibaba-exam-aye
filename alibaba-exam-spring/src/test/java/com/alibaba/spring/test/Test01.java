package com.alibaba.spring.test;

import com.alibaba.spring.autoassemb.CDPlayConfig;
import com.alibaba.spring.autoassemb.CompactDisc;
import com.alibaba.spring.conditionassemb.MagicBean;
import com.alibaba.spring.conditionassemb.MagicInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)//SpringRunner 测试开始时自动创建Spring应用上下文
@ContextConfiguration(classes = CDPlayConfig.class)//ContextConfiguration 告诉它CDPlayConfig中加载配置,因为 CDPlayConfig 包含@ComponentScan,因此最终上下文包含CompactDisc Bean
public class Test01 {
    @Autowired
    private CompactDisc cd;

    @Autowired
    private MagicInterface mc;

    @Test
    public void cdTest(){
        Assert.assertNotNull(cd);//断言cd不为空
    }

    @Test
    public void magicTest(){
        Assert.assertNotNull(mc);//断言cd不为空
    }
}
