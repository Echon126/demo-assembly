package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.concurrent.*;


@EnableRabbit
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        System.out.println("启动Application-api项目");
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void test() {
        Callable<Boolean> callable = () -> {
            logger.info("Start Execute Thread method");
            Thread.sleep(4000);
            return true;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future submit = executorService.submit(callable);
        Object o = null;
        try {
            o = submit.get(3L, TimeUnit.SECONDS);
            logger.info("Thread execute success,Execute result is :{}", o);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            logger.error("Thread execute fail" + Arrays.toString(e.getStackTrace()));
        }
    }
}
