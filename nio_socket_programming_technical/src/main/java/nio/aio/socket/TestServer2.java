package nio.aio.socket;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestServer2 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress("localhost", 8888));

        Future<AsynchronousSocketChannel> socketChannelFuture = serverSocketChannel.accept();

        AsynchronousSocketChannel socketChannel = socketChannelFuture.get();

        ByteBuffer buffer = ByteBuffer.allocate(20);
        Future<Integer> readFuture = socketChannel.read(buffer);
        Future<Integer> readFuture2 = socketChannel.read(buffer); // 重复读 throws ReadPendingException

        System.out.println(new String(buffer.array(), 0, readFuture.get()));

        Thread.sleep(4000);

    }
}
