package com.chaseshu.controller;


import com.chaseshu.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {

    @Autowired
    private Sender sender;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void sendMessage() {


        //模拟N个并发请求
        int N = 500;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for(int i = 0; i < N; i++){
            new Thread(new Send(countDownLatch)).start();
        }

        //计数器减一 所有线程释放 并发访问
        countDownLatch.countDown();

    }


    private class Send implements Runnable{

        private final CountDownLatch countDownLatch;

        public Send(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }


        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "---------------------await");
                countDownLatch.await();//一直阻塞当前线程，直到计数器的值为0
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "---------------------开始发送消息");
            //sender.send();
            amqpTemplate.convertAndSend("hello", Thread.currentThread().getName());
        }
    }
}