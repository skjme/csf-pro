package com.chaseshu.sender;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


@Component
public class Sender {

    Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send() {
        String context = "简单消息发送:" + this;
        logger.info("简单消息发送时间：" + LocalDateTime.now());
        amqpTemplate.convertAndSend("hello", context);
        return "发送成功";
    }
}
