package nio.channels;

import sun.security.x509.FreshestCRLExtension;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 批量读操作
 */
public class Test4_1 {

    private static FileInputStream fisRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws Exception {
        testRead();
//        multiThreadRead();
    }

    public static void testRead() throws Exception{

        fisRef = new FileInputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/b.txt"));
        fileChannel = fisRef.getChannel();
//        fileChannel.position(2); // 从通道的当前位置开始读取

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};

//        byteBuffer1.position(1); // 放入ByteBuffer的当前位置

//        long readLength = fileChannel.read(bufferArray);
        long readLength = fileChannel.read(bufferArray, 0, 1); // offset第一个要访问的缓冲区在数组的索引、length要访问的缓冲区的数量
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        readLength = fileChannel.read(bufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        readLength = fileChannel.read(bufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        readLength = fileChannel.read(bufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        fileChannel.close();
        fisRef.close();
    }

    public static void multiThreadRead() throws Exception{

        fisRef = new FileInputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/a.txt"));
        fileChannel = fisRef.getChannel();

        for(int i = 0; i < 10; i++){

            Thread thread1 = new Thread(){
                @Override
                public void run() {

                    try {
                        ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
                        ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
                        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};

                        long readLength = fileChannel.read(bufferArray);
                        while (readLength != -1){
                           synchronized (Test4_1.class){
                               for (int j = 0; j < bufferArray.length; j++){
                                   byte[] getByte = bufferArray[j].array();
                                   for(int k = 0; k < getByte.length; k++){
                                       System.out.print((char)getByte[k]);
                                   }
                               }
                           }


                            byteBuffer1.clear();
                            byteBuffer2.clear();
                            readLength = fileChannel.read(bufferArray);
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
                            ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
                            ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
                            ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1, byteBuffer2};

                            long readLength = fileChannel.read(bufferArray);
                            while (readLength != -1) {
                                synchronized (Test4_1.class) {
                                    for (int j = 0; j < bufferArray.length; j++) {
                                        byte[] getByte = bufferArray[j].array();
                                        for (int k = 0; k < getByte.length; k++) {
                                            System.out.print((char) getByte[k]);
                                        }
                                    }
                                }


                                byteBuffer1.clear();
                                byteBuffer2.clear();
                                readLength = fileChannel.read(bufferArray);
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
