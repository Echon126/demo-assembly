package com.example.socket.service;

import lombok.*;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PushMessage {

    private String loginName;

    //@ApiModelProperty(value="推送内容")
    private String content;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
