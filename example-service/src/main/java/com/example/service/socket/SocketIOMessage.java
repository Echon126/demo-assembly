package com.example.service.socket;

public class SocketIOMessage {
    private String token;
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SocketIOMessage{" +
                "token='" + token + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
