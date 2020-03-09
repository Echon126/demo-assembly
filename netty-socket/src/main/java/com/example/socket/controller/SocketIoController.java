package com.example.socket.controller;


import com.example.socket.service.PushMessage;
import com.example.socket.service.SocketIOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ZKTT
 */
@Slf4j
@Api(value = "用户controller", tags = {"用户操作接口"})
@RestController
public class SocketIoController {
    @Autowired
    private SocketIOService socketIOService;

    @ApiOperation(value = "获取用户信息", tags = {"获取用户信息copy"}, notes = "注意问题点")
    @ApiImplicitParams({
    })
    @GetMapping(value = "test/message", produces = "application/json")
    public void sendMessage(@RequestBody(required = true) PushMessage pushMessage) {
        log.info("pushmessage:{}", pushMessage.toString());
        PushMessage p = new PushMessage();
        p.setContent("我是被推过来的");
        p.setLoginName("88");
        socketIOService.pushMessageToUser(p);
    }
}
