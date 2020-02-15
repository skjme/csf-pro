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

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        Path path = Paths.get("/Users/ask123/Desktop/a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

//        Future<FileLock> future = channel.lock();
        Future<FileLock> future = channel.lock(0, 3, false);
        FileLock lock = future.get();
        System.out.println("A get lock time = " + System.currentTimeMillis());
        Thread.sleep(8000); // 给出一些时间，用来启动Test2
        lock.release();
        System.out.println("A release lock time = " + System.currentTimeMillis());
        channel.close();
    }
}
