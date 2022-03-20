https://www.baeldung.com/java-mutex

# 1. Overview
   In this tutorial, we'll see different ways to implement a mutex in Java.

# 2. Mutex 互斥锁
   In a multithreaded application, two or more threads may need to access a shared resource at the same time, resulting in unexpected behavior. Examples of such shared resources are data-structures, input-output devices, files, and network connections.
   在多线程应用程序中，两个或更多线程可能需要同时访问共享资源，从而导致意外行为。这种共享资源的例子是数据结构、输入输出设备、文件和网络连接。

We call this scenario a race condition. And, the part of the program which accesses the shared resource is known as the critical section.
So, to avoid a race condition, we need to synchronize access to the critical section.
我们称这种情况为竞争条件。并且，程序中访问共享资源的部分称为临界区。
因此，为了避免竞争条件，我们需要同步对临界区的访问。

A mutex (or mutual exclusion) is the simplest type of synchronizer – it ensures that only one thread can execute the critical section of a computer program at a time.
互斥锁（或互斥）是最简单的同步器类型——它确保一次只有一个线程可以执行计算机程序的关键部分。

To access a critical section, a thread acquires the mutex, then accesses the critical section, and finally releases the mutex. In the meantime, all other threads block till the mutex releases. As soon as a thread exits the critical section, another thread can enter the critical section.
要访问临界区，线程先获取互斥锁，然后访问临界区，最后释放互斥锁。与此同时，所有其他线程都会阻塞，直到互斥锁释放。一旦一个线程退出临界区，另一个线程就可以进入临界区。


# 3. Why Mutex?
```java
   public class SequenceGenerator {

   private int currentValue = 0;

   public int getNextSequence() {
   currentValue = currentValue + 1;
   return currentValue;
   }

}
```


```java
@Test
public void givenUnsafeSequenceGenerator_whenRaceCondition_thenUnexpectedBehavior() throws Exception {
int count = 1000;
Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGenerator(), count);
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
```

Once we execute this test case, we can see that it fails most of the time with the reason similar to:
```java
java.lang.AssertionError: expected:<1000> but was:<989>
at org.junit.Assert.fail(Assert.java:88)
at org.junit.Assert.failNotEquals(Assert.java:834)
at org.junit.Assert.assertEquals(Assert.java:645)
```

The uniqueSequences is supposed to have the size equal to the number of times we've executed the getNextSequence method in our test case. However, this is not the case because of the race condition. Obviously, we don't want this behavior.

So, to avoid such race conditions, we need to make sure that only one thread can execute the getNextSequence method at a time. In such scenarios, we can use a mutex to synchronize the threads.
因此，为了避免这种竞争条件，我们需要确保一次只有一个线程可以执行getNextSequence方法。在这种情况下，我们可以使用互斥锁来同步线程。

There are various ways, we can implement a mutex in Java. So, next, we'll see the different ways to implement a mutex for our SequenceGenerator class.
有多种方式，我们可以在 Java 中实现互斥锁。因此，接下来，我们将看到为我们的SequenceGenerator类实现互斥锁的不同方式。


# 4 实现互斥锁的不同方式
different ways to implement a mutex in java

### 4.1 Using synchronized Keyword
#### The synchronized method

```java
public class SequenceGeneratorUsingSynchronizedMethod extends SequenceGenerator {

    @Override
    public synchronized int getNextSequence() {
        return super.getNextSequence();
    }

}
```


#### the synchronized block use this intrinsic lock
```java
public class SequenceGeneratorUsingSynchronizedBlock extends SequenceGenerator {

    private Object mutex = new Object();

    @Override
    public int getNextSequence() {
        synchronized (mutex) {
            return super.getNextSequence();
        }
    }

}

```


### 4.2 Using ReentrantLock

```java
public class SequenceGeneratorUsingReentrantLock extends SequenceGenerator {

    private ReentrantLock mutex = new ReentrantLock();

    @Override
    public int getNextSequence() {
        try {
            mutex.lock();
            return super.getNextSequence();
        } finally {
            mutex.unlock();
        }
    }
}
```


### 4.3 Using Semaphore

```java
public class SequenceGeneratorUsingSemaphore extends SequenceGenerator {

    private Semaphore mutex = new Semaphore(1);

    @Override
    public int getNextSequence() {
        try {
            mutex.acquire();
            return super.getNextSequence();
        } catch (InterruptedException e) {
            // exception handling code
        } finally {
            mutex.release();
        }
    }
}
```


### 4.4 Using Guava's Monitor Class
```xml
<dependency>
   <groupId>com.google.guava</groupId>
   <artifactId>guava</artifactId>
   <version>31.0.1-jre</version>
</dependency>
```
```java
public class SequenceGeneratorUsingMonitor extends SequenceGenerator {

    private Monitor mutex = new Monitor();

    @Override
    public int getNextSequence() {
        mutex.enter();
        try {
            return super.getNextSequence();
        } finally {
            mutex.leave();
        }
    }

}
```
