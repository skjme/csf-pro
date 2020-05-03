package cn.chaseshu.sink;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Sink - In Spring Cloud Stream, sink is used to consume message from queue.
 *
 * @StreamListener(target = Sink.INPUT)
 * public void processRegisterEmployees(String employee){
 * System.out.println("Employees Registered --"+ employee);
 * }
 */
@Slf4j
@EnableBinding(Sink.class)
public class ProcessRegisterEmployee {

    private static final AtomicInteger NUM = new AtomicInteger(0);

    @StreamListener(target = Sink.INPUT)
    public void processRegisterEmployees(String employee) {
        System.out.println(NUM.getAndIncrement() + " Employees Registered by Client " + employee);
    }

}
