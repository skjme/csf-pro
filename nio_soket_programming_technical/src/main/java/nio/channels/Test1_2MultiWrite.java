package nio.channels;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用多线程同时对FileChannel通道进行写入，验证write方法具有同步特性
 */
public class Test1_2MultiWrite {

    private static FileOutputStream fosRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException, InterruptedException {

        fosRef = new FileOutputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/nio_soket_programming_technical/src/main/java/nio/channels/a.txt"));
        fileChannel = fosRef.getChannel();
        for(int i = 0; i < 10; i++){

            Thread thread1 = new Thread(){
                @Override
                public void run() {

                    try {
                        ByteBuffer buffer = ByteBuffer.wrap("abcde\r\n".getBytes());
                        fileChannel.write(buffer);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };

            Thread thread2 = new Thread(){
                @Override
                public void run() {

                    try {
                        ByteBuffer buffer = ByteBuffer.wrap("我是中国人\r\n".getBytes());
                        fileChannel.write(buffer);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };

            thread1.start();
            thread2.start();
        }

        Thread.sleep(3000);
        fileChannel.close();
        fosRef.close();
    }
}
