package com.chaseshu.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class OrderDispatchConsumer {


    @RabbitListener(queues = "orderDispatchQueue")
    public void messageConsumer(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag){

        // 处理业务逻辑，拿到订单数据
        try{


            //TODO 业务逻辑

            channel.basicAck(tag, false);

        }catch (Exception ex){

        }
    }
}
