package nio.aio.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

public class TestClient2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8888), null, new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {
                try{
                    Future<Integer> writeFuture = socketChannel.write(ByteBuffer.wrap("我是来自客户端2".getBytes()));
                    System.out.println("写入大小：" + writeFuture.get());
                    socketChannel.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
        Thread.sleep(1000);

    }
}
