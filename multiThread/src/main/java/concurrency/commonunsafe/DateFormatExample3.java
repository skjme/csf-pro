package concurrency.commonunsafe;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.datetime.joda.JodaDateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.datetime.joda.JodaTimeContext;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author chaseshu
 * @date 2022/2/18 10:54
 * @apiNote
 */
@Slf4j
public class DateFormatExample3 {
    
    // 请求总数
    public static int clientTotal = 5000;
    
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");
    
    public static void main(String [] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        
        for(int i = 0; i < clientTotal; i++){
            final int idx = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(idx);
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        
        countDownLatch.await();
        executorService.shutdown();
        
    
    }
    
    private static void update(final int i ) {
        DateTime dateTime = DateTime.parse("20220218", dateTimeFormatter);
        log.info(" i = {}, date = {}", i, dateTime);
    }
    
}
