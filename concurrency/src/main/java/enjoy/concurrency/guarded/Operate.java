package enjoy.concurrency.guarded;

import java.util.concurrent.TimeUnit;

public class Operate {

    public static String dbOprate(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result";
    }


}
