package nio.aio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test7Client2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        final AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();

        socketChannel.connect(new InetSocketAddress("localhost", 8888), null, new CompletionHandler<Void, Object>() {
                    @Override
                    public void completed(Void result, Object attachment) {

                            ByteBuffer buffer = ByteBuffer.allocate(Integer.MAX_VALUE/100);
                            for(int i = 0; i < Integer.MAX_VALUE/100-3; i++){
                                buffer.put("1".getBytes());
                            }
                            buffer.put("end".getBytes());
                            buffer.flip(); // substring

                            socketChannel.write(buffer, 1, TimeUnit.SECONDS, null, new CompletionHandler<Integer, Object>() {
                                @Override
                                public void completed(Integer result, Object attachment) {
                                    try {
                                        socketChannel.close();
                                        System.out.println("client close");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void failed(Throwable exc, Object attachment) {

                                }
                            });


                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("failed");
                        System.out.println(exc.getMessage());
                    }
                });

        Thread.sleep(10000);
    }
}
