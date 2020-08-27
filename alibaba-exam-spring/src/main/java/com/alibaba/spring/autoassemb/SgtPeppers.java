package com.alibaba.spring.autoassemb;

import org.springframework.stereotype.Component;


@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt.Peppers LoneLy Hearts Club Band";
    private String article = "The Beatles";
    @Override
    public void play() {
        System.out.println("playing"+title+"by"+article);
    }
}
