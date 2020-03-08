package com.example.assembly.controller;

import com.example.assembly.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class AssemblyController {
    private ExecutorService executors = Executors.newFixedThreadPool(1);

    @Autowired
    private AssemblyService assemblyService;
    @RequestMapping("/example")
    public String  infoExample(){
        //assemblyService.sendSMS();
        executors.execute(()->{
            System.out.println("线程名称"+Thread.currentThread().getId());
        });
        executors.shutdown();
        System.out.println("zhi"+new Date());
        return "example";
    }
}
