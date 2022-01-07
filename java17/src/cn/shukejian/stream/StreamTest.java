package cn.shukejian.stream;

import java.util.stream.Stream;

/**
 * create stream 5 种方式
 * 1 通过数组
 * 2 通过集合来
 * 3 通过Stream.generate方法创建
 * 4 通过Stream.iterate方法创建
 * 5 其他API创建
 */
public class StreamTest {
    
    public static void main(String[] args) {
    
        Integer [] ints = {1, 2, 3, 4, 5};
        final Stream<Integer> arr = Stream.of(ints);
        arr.forEach(System.out::println);
        System.out.println();
    
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);
        System.out.println();
    
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
        
    }
    
}
