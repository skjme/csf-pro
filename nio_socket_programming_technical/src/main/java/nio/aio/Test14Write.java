package nio.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test14Write {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("/Users/ask123/Desktop/b.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        // 写方式1
//        ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
//        Future<Integer>  future = channel.write(buffer, channel.size());
//        System.out.println("length=" + future.get());
//        channel.close();

        // 写方法2
        ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
        channel.write(buffer, channel.size(), "我是附加数据", new CompletionHandler<Integer, String>() {
            @Override
            public void completed(Integer result, String attachment) {
                System.out.println(result);
                System.out.println(attachment);
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("failed");
            }
        });
        channel.close();
        Thread.sleep(2000);
    }
}
