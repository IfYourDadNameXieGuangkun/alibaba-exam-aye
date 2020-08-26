package com.alibaba.java8;

import com.alibaba.java8.interfaces.Java8Interface1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication(scanBasePackages = {"com.alibaba.java8"})
@Slf4j
public class Java8Application  {


    private final List<Java8Interface1> interface1s;

    public Java8Application(List<Java8Interface1> interface1s) {
        this.interface1s= interface1s.stream().sorted(Comparator.comparing(Ordered::getOrder)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            List<Integer> orders = interface1s.stream().map(Ordered::getOrder).collect(Collectors.toList());
            log.info(orders.size()+"");
        };
    }
}
