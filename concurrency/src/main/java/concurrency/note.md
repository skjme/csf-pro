
## 不可变对象 Immutable

final class/method/variable

Collections.unmodifiableXXX:Collection、List、Set、Map...

Guava: ImmutableXXX:Collection、List、Set、Map...

## 线程不安全与写法
- StringBuilder -> StringBuffer
- SimpleDateFormat -> JodaTime
- ArrayList, HashSet, HashMap等Collections

## 线程安全 - 同步容器

- ArrayList -> Vector, Stack
- HashMap -> HashTable(key,value不能为空)
- Collections.synchronizedXXX(List, Set, Map)

## 线程安全 - 并发容器 J.U.C

- ArrayList -> CopyOnWriteArrayList
- HashSet、TreeSet -> CopyOnWriteArraySet、ConcurrentSkipListSet
- HashMap、TreeMap -> ConcurrentHashMap、ConcurrentSkipListMap

## AQS 同步组件
- CountDownLatch
- Semaphore
- CyclicBarrier
- ReentrantLock
- Condition
- FutureTask
 