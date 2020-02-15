package nio.aio;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;

public class Test4HandlerFailed {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        Path path = Paths.get("/Users/ask123/Desktop/a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("begin time=" + System.currentTimeMillis());
        channel.close();
        channel.lock("我是字符串我是附件", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    System.out.println("complited attachment=" + attachment);
                    result.release();
                    channel.close();
                    System.out.println("release and close");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("failed attachment=" + attachment);
                System.out.println("getMessage=" + exc.getMessage());
                System.out.println(exc.getClass().getName());
            }
        });
        System.out.println("end time=" + System.currentTimeMillis());
        Thread.sleep(3000);
    }
}
