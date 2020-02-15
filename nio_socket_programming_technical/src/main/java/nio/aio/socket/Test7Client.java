package nio.aio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test7Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        final AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();

        socketChannel.connect(new InetSocketAddress("localhost", 8888), null, new CompletionHandler<Void, Object>() {
                    @Override
                    public void completed(Void result, Object attachment) {
                        try{
                            //socketChannel.close();

                            ByteBuffer buffer = ByteBuffer.allocate(Integer.MAX_VALUE/100);
                            for(int i = 0; i < Integer.MAX_VALUE/100-3; i++){
                                buffer.put("1".getBytes());
                            }
                            buffer.put("end".getBytes());
                            buffer.flip(); // substring

                            int writeSum = 0;
                            while(writeSum < buffer.limit()){
                                Future<Integer> writeFutrue = socketChannel.write(buffer);
                                Integer writeLength = writeFutrue.get();
                                writeSum += writeLength;
                            }
                            socketChannel.close();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
