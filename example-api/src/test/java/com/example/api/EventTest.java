package com.example.api;

import com.example.api.event.OrderEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EventTest {
    private final Logger logger = LoggerFactory.getLogger(EventTest.class);
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test() {
        logger.info("开始发布事件");
        OrderEvent event = new OrderEvent();
        applicationContext.publishEvent(event);
        logger.info("事件发布完成");
    }
}
