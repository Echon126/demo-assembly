package com.example.api.pub;


import com.example.common.enums.redis.RedisChannelEnums;

public interface RedisPub {


    /**
     * 集成redis实现消息发布订阅模式-双通道
     * @param redisChannelEnums 枚举定义
     * @param basePubMessage 消息
     */
    void sendMessage(RedisChannelEnums redisChannelEnums, BasePubMessage basePubMessage);

}