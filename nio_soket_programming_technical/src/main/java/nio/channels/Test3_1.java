package nio.channels;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 批量写操作
 *
 */
public class Test3_1 {

    public static void main(String[] args) throws Exception {

//        test();
        multiThreadWrite();

    }

    /**
     * 测试批量写人
     * @throws Exception
     */
    public static void test() throws Exception {


        FileOutputStream fosRef = new FileOutputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/a.txt"));
        FileChannel fileChannel = fosRef.getChannel();

        fileChannel.write(ByteBuffer.wrap("123456".getBytes()));
        fileChannel.position(3);

//        ByteBuffer byteBuffer1 = ByteBuffer.wrap("ooooo1".getBytes());
//        ByteBuffer byteBuffer2 = ByteBuffer.wrap("ooooo2".getBytes());

        ByteBuffer byteBuffer1 = ByteBuffer.wrap("abcde1".getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("uvwxy2".getBytes());

        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};

        // 验证write(ByteBuffer[] srcs)方法将ByteBuffer的remaining写入通道
        byteBuffer1.position(1);
        byteBuffer1.limit(3); // bc

        byteBuffer2.position(2);
        byteBuffer2.limit(4); // wx

        fileChannel.write(bufferArray);

        fileChannel.close();
        fosRef.close();
    }

    /**
     * 多线程验证写具有同步特性
     */
    public static void multiThreadWrite() throws Exception {
        FileOutputStream fosRef = new FileOutputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/nio_soket_programming_technical/src/main/java/nio/channels/a.txt"));
        FileChannel fileChannel = fosRef.getChannel();
        for(int i = 0; i < 10; i++){

            Thread thread1 = new Thread(){
                @Override
                public void run() {

                    try {
                        ByteBuffer byteBuffer1 = ByteBuffer.wrap("ooooo1\r\n".getBytes());
                        ByteBuffer byteBuffer2 = ByteBuffer.wrap("ooooo2\r\n".getBytes());

                        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
                        fileChannel.write(bufferArray);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };

            Thread thread2 = new Thread(){
                @Override
                public void run() {

                    try {
                        ByteBuffer byteBuffer1 = ByteBuffer.wrap("zzzzz1\r\n".getBytes());
                        ByteBuffer byteBuffer2 = ByteBuffer.wrap("zzzzz2\r\n".getBytes());

                        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};
                        fileChannel.write(bufferArray);
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
