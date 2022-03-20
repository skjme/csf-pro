package mutex;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author chaseshu
 * @date 2022/3/19 18:22
 * @apiNote
 */
public class T4 {
    
    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenUnexpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingMonitor(), count);
        Assert.assertEquals(count, uniqueSequences.size());
    }
    
    private Set<Integer> getUniqueSequences(SequenceGenerator generator, int count) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            futures.add(executor.submit(generator::getNextSequence));
        }
        
        for (Future<Integer> future : futures) {
            uniqueSequences.add(future.get());
        }
        
        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
        
        return uniqueSequences;
    }
}
