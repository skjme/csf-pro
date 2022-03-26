package concurrency.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * @author chaseshu
 * @date 2022/2/18 10:02
 * @apiNote
 */
public class ImmutableExample3 {
    
    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet<Integer> set = ImmutableSet.copyOf(list);
    
    
    public static void main(String[] args) {
        // list.add(4);
        // set.add(4);
    }
    
}
