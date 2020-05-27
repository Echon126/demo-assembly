package com.example.service.config;

import com.google.gson.Gson;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

@Data
abstract class BaseSubMessage {

    /**
     * 发布订阅频道名称
     */
    private String channel;

    private String extra;

    private String json;

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

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    BaseSubMessage(String json) {
        if (StringUtils.isEmpty(json)) {
            return;
        }

        this.json = json;
        Map map = new Gson().fromJson(this.json, Map.class);
        // BeanHelper.populate(this, map);
    }

}