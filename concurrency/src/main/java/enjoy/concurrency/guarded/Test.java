package enjoy.concurrency.guarded;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "enjoy")
public class Test {
    public static void main(String[] args) {

        GuardedObject1 guardedObject = new GuardedObject1();


        new Thread(() -> {
            String result = Operate.dbOprate();
            log.debug("t1 set完毕...");
            guardedObject.setResponse(result);
        },"t1").start();


        log.debug("主线程等待（wait）t1 set");
        //有没有实现超时？
        Object response = guardedObject.getResponse(20000);


        log.debug("response: [{}]",response);
    }



}
