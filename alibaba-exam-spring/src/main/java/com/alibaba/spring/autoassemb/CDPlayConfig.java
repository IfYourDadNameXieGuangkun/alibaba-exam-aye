package com.alibaba.spring.autoassemb;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

/**
 * 若@ComponentScan未设置任何属性,那么默认扫描配置类所在的基础包 也就是 com.alibaba.spring.autoassemb
 */
@ComponentScan(basePackages ={ "com.alibaba.spring.autoassemb","com.alibaba.spring.conditionassemb"})
//@ComponentScan(basePackageClasses = SgtPeppers.class)
@Profile("local")
public class CDPlayConfig {
}
