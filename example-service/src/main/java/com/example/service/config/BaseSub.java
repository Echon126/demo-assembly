package com.example.service.config;

public interface BaseSub {

    /**
     * 接收消息
     *
     * @param jsonMessage json字符
     */
    void receiveMessage(String jsonMessage);
}