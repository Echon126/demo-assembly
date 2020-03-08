package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {
    @RabbitListener(queues = "t_message_f")
    public void receive1(String message) throws InterruptedException {
        Thread.sleep(1000);
        System.err.println("xudc -- receive1接收到消息：" + message);
    }



}
