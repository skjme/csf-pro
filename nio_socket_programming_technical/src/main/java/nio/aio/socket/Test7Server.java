package nio.aio.socket;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test7Server {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress("localhost", 8888));

        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel ch, Object attachment) {
                serverSocketChannel.accept(null, this); // continue next accept
                ByteBuffer buffer = ByteBuffer.allocate(Integer.MAX_VALUE / 100);
                ch.read(buffer, 10, TimeUnit.SECONDS, null, new CompletionHandler<Integer, Object>() {
//                ch.read(buffer, 10, TimeUnit.MICROSECONDS, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        if(result == -1){
                            System.out.println(" 客户端没有传输数据就执行close了， 到stream end");
                        }
                        if(result == buffer.limit()){
                            System.out.println("服务器获得客户端完整的数据");
                            System.out.println(new String(buffer.array(), 0, buffer.limit()));
                        }
                        try{
                            ch.close();
                            System.out.println("服务器close");
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("read failed");
                        System.out.println(exc.getMessage());
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("accept failed");
            }
        });

        while (true){

        }

    }
}
