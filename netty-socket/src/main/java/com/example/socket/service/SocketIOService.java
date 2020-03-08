package com.example.socket.service;

public interface SocketIOService {
    public static final String PUSH_EVENT = "push-event";

    void start();

    void stop();

    void pushMessageToUser(PushMessage pushMessage);


    //todo https://www.jianshu.com/p/c67853e729e2
    //todo http://www.52im.net/forum.php?mod=viewthread&tid=189&ctid=15
    //todo https://blog.csdn.net/ljyhust/article/details/77620620
    //todo https://www.cnblogs.com/syscn/p/11934929.html

}
