package com.chaseshu.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@RabbitListener(queues = "hello")
public class Receiver {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void process(String Str) {
        logger.info("接收消息：" + Str);
        logger.info("接收消息时间：" + LocalDateTime.now());
    }
}
