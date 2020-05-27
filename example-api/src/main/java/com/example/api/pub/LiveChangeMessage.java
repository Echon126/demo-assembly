package com.example.api.pub;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class LiveChangeMessage extends BasePubMessage {
    public String getLiveIds() {
        return liveIds;
    }

    public void setLiveIds(String liveIds) {
        this.liveIds = liveIds;
    }

    /**
     * 直播Ids
     */
    private String liveIds;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this, LiveChangeMessage.class);
    }

}