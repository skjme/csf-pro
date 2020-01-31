package nio.channels;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;

/**
 * 使用多线程同时对FileChannel通道进行读取，验证Read方法具有同步特性
 */
public class Test2_3MultiThreadRead {

    private static FileOutputStream fosRef;
    private static FileChannel fileChannel;
    private static FileInputStream fisRef;


    static void genTestData()throws IOException, InterruptedException {

        // 生成测试数据 27组字符串
        //aaaa0aaaa1aaaa2aaaa3aaaa4aaaa5aaaa6aaaa7aaaa8aaaa9bbbb0bbbb1bbbb2bbbb3bbbb4bbbb5bbbb6bbbb7bbbb8bbbb9cccc0cccc1cccc2cccc3cccc4cccc5cccc6cccc7cccc8cccc9
        fosRef = new FileOutputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/c.txt"));
        fileChannel = fosRef.getChannel();

        char [] chars = new char[] {'a', 'b', 'c'};
        for(int j = 0; j < chars.length; j++){
            for (int i = 0; i <= 9; i++){
                String str = String.join("", Collections.nCopies(4, String.valueOf(chars[j]))) + i;
                System.out.println(str);
                ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
                fileChannel.write(buffer);
            }

        }

        fileChannel.close();
        fosRef.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        // 生成测试数据
          genTestData();

        // 读取数据，验证read方法具有同步特性
        fisRef = new FileInputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/c.txt"));
        fileChannel = fisRef.getChannel();

        for(int i = 0; i < 10; i++){

            Thread thread1 = new Thread(){
                @Override
                public void run() {

                    try {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                        int readLength = fileChannel.read(byteBuffer);
                        while (readLength != -1){
                            byte[] getByte = byteBuffer.array();
                            System.out.println(new String(getByte, 0, readLength));

                            byteBuffer.clear();
                            readLength = fileChannel.read(byteBuffer);
                        }

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };

            Thread thread2 = new Thread(){
                @Override
                public void run() {

                    try {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                        int readLength = fileChannel.read(byteBuffer);
                        while (readLength != -1){
                            byte[] getByte = byteBuffer.array();
                            System.out.println(new String(getByte, 0, readLength));

                            byteBuffer.clear();
                            readLength = fileChannel.read(byteBuffer);
                        }
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
        fisRef.close();
    }
}
