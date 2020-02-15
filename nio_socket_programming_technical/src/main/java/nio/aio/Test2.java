package nio.aio;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test2 {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        Path path = Paths.get("/Users/ask123/Desktop/a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("lock begin = " + System.currentTimeMillis());
//        Future<FileLock> future = channel.lock();
//        Future<FileLock> future = channel.lock(0, 3, false);
        Future<FileLock> future = channel.lock(0, 4, false); // 重叠锁
        System.out.println("lock end = " + System.currentTimeMillis());
        FileLock lock = future.get();
        System.out.println("B get lock time = " + System.currentTimeMillis());
        lock.release();
        channel.close();
    }
}
