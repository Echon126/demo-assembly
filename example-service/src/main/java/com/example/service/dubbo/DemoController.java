package com.example.service.dubbo;


import com.alibaba.dubbo.config.annotation.Reference;
import com.tianta.ccube.rt.xdte.controller.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference
    private Demo demo;

    @RequestMapping("/get")
    public String getDemo() {
        return this.demo.testDubbo();
    }
}
