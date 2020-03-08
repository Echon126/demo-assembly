package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
@MapperScan(basePackages = {"com.example.demo.mapper"})
public class Application7015 {
    public static void main(String[] args) {
        SpringApplication.run(Application7015.class,args) ;
    }
}
