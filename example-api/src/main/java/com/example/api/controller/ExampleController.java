package com.example.api.controller;

import com.example.api.event.OrderEvent;
import com.example.api.pub.LiveChangeMessage;
import com.example.api.pub.RedisPub;
import com.example.common.enums.redis.RedisChannelEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    private final Logger logger = LoggerFactory.getLogger(ExampleController.class);
    @Autowired
    private RedisPub redisPub;



    @RequestMapping("/test")
    public String pusMessage() {
        LiveChangeMessage basePubMessage = new LiveChangeMessage();
        basePubMessage.setChannel("ssss");
        basePubMessage.setExtra("xxxxxx");
        basePubMessage.setLiveIds("xxxxxxxxxxxxxxxxx");
        redisPub.sendMessage(RedisChannelEnums.LIVE_INFO_CHANGE, basePubMessage);

        return "发布成功";
    }

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/test01")
    public String Listener() {
        logger.info("开始发布事件");
        OrderEvent event = new OrderEvent();
        applicationContext.publishEvent(event);
        logger.info("事件发布完成");
        return "发布成功";
    }
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/test02")
    public String ListenerMQ() {
        logger.info("开始发布事件");
        for(int i=0;i<100;i++){
            rabbitTemplate.convertAndSend("t_message_f", "cccccccccccccccccccc");

        }

        logger.info("事件发布完成");
        return "发布成功";
    }
}
