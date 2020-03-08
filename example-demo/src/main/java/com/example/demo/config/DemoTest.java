package com.example.demo.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DemoTest {

    public void booleanDynamic(){
    }

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("helloWorldSession");

        Message message = new Message();
        message.setId("123");
        message.setName("haha");
        kieSession.insert(message);

        int i = kieSession.fireAllRules();//fire:火
        System.out.println("========"+i);
        kieSession.dispose();//处置，处理
    }
}
