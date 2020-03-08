package com.example.api.pub;


import com.example.common.enums.RedisChannelEnums;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisPubImpl implements RedisPub {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void sendMessage(RedisChannelEnums redisChannelEnums, BasePubMessage basePubMessage) {

        if(redisChannelEnums ==null || basePubMessage ==null){
            return;
        }

        basePubMessage.setChannel(redisChannelEnums.getCode());
        stringRedisTemplate.convertAndSend(redisChannelEnums.getCode(), basePubMessage.toString());
        System.out.println("发布成功！");
    }
}