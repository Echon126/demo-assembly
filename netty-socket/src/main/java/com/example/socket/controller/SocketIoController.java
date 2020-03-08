package com.example.socket.controller;


import com.example.socket.service.PushMessage;
import com.example.socket.service.SocketIOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocketIoController {
    @Autowired
    private SocketIOService socketIOService;

    @GetMapping("test/message")
    public void sendMessage() {
        PushMessage p = new PushMessage();
        p.setContent("我是被推过来的");
        p.setLoginName("88");
        socketIOService.pushMessageToUser(p);
    }
}