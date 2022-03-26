package enjoy.concurrency.guarded;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "enjoy")
public class TestTimeOut {
    public static void main(String[] args) {
        GuardedObjectTimeOut guardedObject = new GuardedObjectTimeOut();

        //4s执行完
        new Thread(() -> {
            String result = Operate.dbOprate();
            log.debug("t1 set完毕...");
            guardedObject.setResponse(result);
        },"t1").start();


        log.debug("主线程等待t1 set");

        Object response = guardedObject.getResponse(2000);
        log.debug("response: [{}] ",response);
    }



}
