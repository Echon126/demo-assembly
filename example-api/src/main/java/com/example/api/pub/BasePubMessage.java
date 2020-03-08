package com.example.api.pub;

import com.google.gson.Gson;
import lombok.Data;

@Data
public abstract class BasePubMessage {

    /**
     * 发布订阅频道名称
     */
    protected String channel;

    protected String extra;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this, BasePubMessage.class);
    }

}