package concurrency.commonunsafe;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author chaseshu
 * @date 2022/2/18 12:43
 * @apiNote
 */
@Slf4j
@NotThreadSafe
public class CopyOnWriteArraySetExample1 {
    
    private static Set<Integer> set = new CopyOnWriteArraySet();
    
    // 请求总数
    public static int clientTotal = 5000;
    
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    
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
        
        log.info("size = {} ", set.size());
    
    }
    
    private static void update(int i) {
      set.add(i);
    }
    
}
