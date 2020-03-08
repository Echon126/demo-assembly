package com.example.assembly.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.SimpleFormatter;

@Service
public class AssemblyService {
    @Async
    public String  sendSMS()  {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行异步任务"+ new Date());

        return "finished";
    }


    public static void main(String[] args) {
        //SimpleFormatter sdf = new SimpleFormatter("yyyy-MM-dd");
    }


}
