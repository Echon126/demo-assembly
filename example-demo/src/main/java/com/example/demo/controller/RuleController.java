package com.example.demo.controller;


import com.example.demo.entity.QueryParam;
import com.example.demo.entity.RuleResult;
import com.example.demo.service.RuleEngineService;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/rule")
public class RuleController {
    private final Logger logger = LoggerFactory.getLogger(RuleController.class);

    @Resource
    private KieSession kieSession;
    @Resource
    private RuleEngineService ruleEngineService ;

    @RequestMapping("/param")
    public void param (){
        QueryParam queryParam1 = new QueryParam() ;
        queryParam1.setParamId("1");
        queryParam1.setParamSign("+");
        QueryParam queryParam2 = new QueryParam() ;
        queryParam2.setParamId("2");
        queryParam2.setParamSign("-");
        // 入参
        kieSession.insert(queryParam1) ;
        kieSession.insert(queryParam2) ;
        kieSession.insert(this.ruleEngineService) ;

        // 返参
        RuleResult resultParam = new RuleResult() ;
        kieSession.insert(resultParam) ;
        kieSession.fireAllRules() ;
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/test02")
    public String ListenerMQ() {
        logger.info("开始发布事件");
        rabbitTemplate.convertAndSend("t_message_f", "cccccccccccccccccccc");

        logger.info("事件发布完成");
        return "发布成功";
    }
}
