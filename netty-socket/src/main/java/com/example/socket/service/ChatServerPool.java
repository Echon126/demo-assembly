package com.example.socket.service;

import com.corundumstudio.socketio.SocketIOClient;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatServerPool {
    private static final ConcurrentSkipListMap<String, SocketIOClient> webSocketMap = new ConcurrentSkipListMap<>();
    public static AtomicInteger onLineCount = new AtomicInteger();


    public static SocketIOClient getSocketIOClientByClientID(String clientID) {
        return webSocketMap.get(clientID);
    }

    public static void addUser(String clientID, SocketIOClient socketIOClient) {
        if (null != socketIOClient) {
            webSocketMap.put(clientID, socketIOClient);
            onLineCount.incrementAndGet();
        }
    }

    public static Collection<String> getOnLineUser() {
        Set<String> setUser = webSocketMap.keySet();
        return setUser;
    }

    public static boolean removeUser(String clientID) {
        if (webSocketMap.containsKey(clientID)) {
            webSocketMap.remove(clientID);
            return true;
        } else {
            return false;
        }
    }

    // 向特定的用户发送数据
    public static void sendMessageToUser(String clientId, String event, String msg) {
        if (webSocketMap.containsKey(clientId) && !"".equals(msg)) {
            webSocketMap.get(clientId).sendEvent(event, msg);
        }
    }

    //向特定的用户发送数据
    public static void sendMessageToUserBySocketClient(SocketIOClient conn, String event, String msg) {
        if (conn != null && !"".equals(msg)) {
            conn.sendEvent(event, msg);
        }
    }

    //向所有的用户发送消息
    public static void sendMessageAll(String event, String message) {
        Collection<SocketIOClient> cs = webSocketMap.values();
        synchronized (cs) {
            if (event != null && !"".equals(event)) {
                for (SocketIOClient conn : cs) {
                    if (conn == null) continue;
                    conn.sendEvent(event, message);
                }
            } else {
                for (SocketIOClient conn : cs) {
                    if (conn == null) continue;
                    conn.sendEvent(message);
                }
            }
        }
    }

}
