    package com.example.api.mq;

    import org.springframework.amqp.rabbit.annotation.RabbitHandler;
    import org.springframework.amqp.rabbit.annotation.RabbitListener;
    import org.springframework.stereotype.Component;

    @Component
    @RabbitListener(queues = "t_message_f")
    public class RabbitMQListener {
        @RabbitHandler
        public void receive1(String message) throws InterruptedException {
            Thread.sleep(1000);
            System.err.println("xudc -- receive1接收到消息：" + message);
        }
    /*

        @RabbitListener(queues = "xudc.book")
        public void receive2(String message) {
            System.err.println("xudc.book -- receive2接收到消息：" + message);
        }

        @RabbitListener(queues = "andy")
        public void receive3(String message) {
            System.err.println("andy -- receive3接收到消息：" + message);
        }
    */

    }
