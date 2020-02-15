package nio.aio;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;

public class Test8_1 {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        Path path = Paths.get("/Users/ask123/Desktop/a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("A begin time=" + System.currentTimeMillis());
        channel.lock("我是附加值", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    Thread.sleep(9000);
                    System.out.println("A completed attachment=" + attachment);
                    result.release();
                    System.out.println("A release lock time=" + System.currentTimeMillis());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("failed attachment=" + attachment);
                System.out.println("getMessage=" + exc.getMessage());
            }
        });
        System.out.println("A end time=" + System.currentTimeMillis());
        Thread.sleep(10000);
        channel.close();
    }
}
