package com.example.api.event;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;


@Component("defaultOrderListener")
@AllArgsConstructor
@EnableAsync
public class OrderListener {

    @Async
    @EventListener
    public void macthPrice(OrderEvent event) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("订单监听器");
    }


}
