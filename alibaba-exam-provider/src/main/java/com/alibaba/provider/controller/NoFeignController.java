package com.alibaba.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**Consumer-->Provider
 * Consumer项目传统方法实现服务之间的调用
 */
@RestController
public class NoFeignController {

    @GetMapping("echo")
    public String echo(@PathVariable String name){
        System.out.println(name);
        return name;
    }
}
