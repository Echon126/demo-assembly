package com.example.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SocketIOApplication {
    public static void main(String[] args) {
        System.out.println("start SocketIOApplication");
        SpringApplication.run(SocketIOApplication.class, args);
    }
}
