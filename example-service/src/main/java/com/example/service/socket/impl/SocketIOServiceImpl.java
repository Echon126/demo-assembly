package com.example.service.socket.impl;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.example.service.socket.PushMessage;
import com.example.service.socket.SocketIOMessage;
import com.example.service.socket.SocketIOService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service(value = "SocketIOService")
public class SocketIOServiceImpl implements SocketIOService {
    private final static Logger logger = LoggerFactory.getLogger(SocketIOServiceImpl.class);
    private static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();
    @Autowired
    private SocketIOServer socketIOServer;


    @PostConstruct
    private void autoStartup() {
        start();
    }

    @PreDestroy
    private void autoStop() {
        stop();
    }

    @Override
    public void start() {
        System.out.println("start socketIO websocket");
        //监听客户端连接
        socketIOServer.addConnectListener(client -> {
            String loginUserNum = getParamsByClient(client);
            if (loginUserNum != null) {
                clientMap.put(loginUserNum, client);
            }
        });

        //监听客户端断开连
        socketIOServer.addDisconnectListener(client -> {
            String loginUserNum = getParamsByClient(client);
            if (loginUserNum != null) {
                clientMap.remove(loginUserNum);
                client.disconnect();
            }
        });

        //处理自定义的之间，与连接监听类型
        socketIOServer.addEventListener(PUSH_EVENT, SocketIOMessage.class, (client, data, ackSender) -> {
            //TODO do something
            logger.info("receive web form " + data.toString());

            SocketIOMessage message = new SocketIOMessage();
            message.setToken("test ack");
            message.setMessage("server token");
            ackSender.sendAckData(message);
        });

        socketIOServer.start();
    }

    @Override
    public void stop() {
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;

        }
    }

    @Override
    public void pushMessageToUser(PushMessage pushMessage) {
        String loginNameNum = pushMessage.getLoginName();
        if (!StringUtils.isEmpty(loginNameNum)) {
            SocketIOClient client = clientMap.get(loginNameNum);
            if (null != client) {
                client.sendEvent(PUSH_EVENT, pushMessage);
            }

        }
    }


    private String getParamsByClient(SocketIOClient client) {
        Map<String, List<String>> params = client.getHandshakeData().getUrlParams();
        List<String> list = params.get("loginUserNum");
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }
}
