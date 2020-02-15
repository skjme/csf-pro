package nio.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test13Read {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("/Users/ask123/Desktop/a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        // 读取方式1
//        ByteBuffer buffer = ByteBuffer.allocate(3);
//        Future<Integer> future = channel.read(buffer, 0);
//        System.out.println("read length = " + future.get());
//        channel.close();
//        System.out.println(new String(buffer.array(), 0, future.get()));

        // 读取方式2
        ByteBuffer buffer = ByteBuffer.allocate(3);
        channel.read(buffer, 0, "我附加的参数", new CompletionHandler<Integer, String>(){

            @Override
            public void completed(Integer result, String attachment) {
                System.out.println("completed result=" + result + " attachment=" + attachment);
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("failed");
            }
        });
        channel.close();
        Thread.sleep(2000);
        System.out.println(new String(buffer.array(), 0, buffer.position()));




    }
}
