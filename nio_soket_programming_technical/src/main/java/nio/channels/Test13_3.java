package nio.channels;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 在FileLock lock(long position, long size, boolean shared)方法调用期间，
 * 如果另一个线程关闭了此通道，则抛出AsynchronousCloseException异常。
 */
public class Test13_3 {


    public static void main(String[] args) throws IOException, InterruptedException {

        FileOutputStream fileA = new FileOutputStream("/Users/ask123/Desktop/a.txt");
        FileChannel fileChannelA = fileA.getChannel();

        Thread a = new Thread(){
            @Override
            public void run() {

                try{
                    fileChannelA.lock(1, 2, false);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        Thread b = new Thread(){
            @Override
            public void run() {

                try{
                    fileChannelA.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        a.start();
        Thread.sleep(1);
        b.start();

        Thread.sleep(1000);
        fileA.close();
        fileChannelA.close();

    }
}
