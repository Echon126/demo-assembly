package com.example.service.config;


import org.springframework.stereotype.Component;

@Component
public class LiveChangeSub implements BaseSub {

    /**
     * 只是定义的注解测试，可以换成自己的
     */


    @Override
    public void receiveMessage(String jsonMessage) {

        System.out.println("项目aries-server.....................");
        //注意通道调用的方法名要和RedisConfig2的listenerAdapter的MessageListenerAdapter参数2相同
        System.out.println("这是 LiveChangeSub" + "-----" + jsonMessage);
    }
}