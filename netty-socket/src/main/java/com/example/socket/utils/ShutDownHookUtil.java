package com.example.socket.utils;

import java.sql.SQLOutput;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZKTT
 */
public class ShutDownHookUtil {
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                close();
            }
        }));
    }

    private static void close() {
        try {
            System.out.println("clean");
            executorService.shutdown();
            System.out.println(executorService.awaitTermination(10000, TimeUnit.SECONDS));
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final int index = i;
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("yse" + index);
                }
            }, 3, TimeUnit.SECONDS);
            System.out.println("add thread");
        }
    }

    //TODO 优雅的关闭线程池

}










































