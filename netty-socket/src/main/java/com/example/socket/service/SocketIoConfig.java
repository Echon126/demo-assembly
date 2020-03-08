package com.example.socket.service;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "socketio")
public class SocketIoConfig {
    private String host;
    private Integer port;
    private int bossCount;
    private int workCount;
    private boolean allowCustomRequests;
    private int upgradeTimeout;
    private int pingTimeout;
    private int pingInterval;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public int getBossCount() {
        return bossCount;
    }

    public void setBossCount(int bossCount) {
        this.bossCount = bossCount;
    }

    public int getWorkCount() {
        return workCount;
    }

    public void setWorkCount(int workCount) {
        this.workCount = workCount;
    }

    public boolean isAllowCustomRequests() {
        return allowCustomRequests;
    }

    public void setAllowCustomRequests(boolean allowCustomRequests) {
        this.allowCustomRequests = allowCustomRequests;
    }

    public int getUpgradeTimeout() {
        return upgradeTimeout;
    }

    public void setUpgradeTimeout(int upgradeTimeout) {
        this.upgradeTimeout = upgradeTimeout;
    }

    public int getPingTimeout() {
        return pingTimeout;
    }

    public void setPingTimeout(int pingTimeout) {
        this.pingTimeout = pingTimeout;
    }

    public int getPingInterval() {
        return pingInterval;
    }

    public void setPingInterval(int pingInterval) {
        this.pingInterval = pingInterval;
    }

    @Bean
    public SocketIOServer socketIOServer() {
        SocketConfig config = new SocketConfig();
        config.setTcpNoDelay(true);
        config.setSoLinger(0);
        com.corundumstudio.socketio.Configuration con = new com.corundumstudio.socketio.Configuration();
        con.setSocketConfig(config);
        con.setHostname(host);
        con.setPort(port);
        con.setBossThreads(bossCount);
        con.setWorkerThreads(workCount);
        con.setAllowCustomRequests(allowCustomRequests);
        con.setUpgradeTimeout(upgradeTimeout);
        con.setPingInterval(pingInterval);
        con.setPingTimeout(pingTimeout);
        con.setAuthorizationListener(new AuthorizationListener() {
            @Override
            public boolean isAuthorized(HandshakeData handshakeData) {
                String username = handshakeData.getSingleUrlParam("username");
                String password = handshakeData.getSingleUrlParam("password");
                System.out.println("username==" + username + "password==" + password);
                return true;
            }
        });
        return new SocketIOServer(con);
    }
}
