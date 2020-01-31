package nio.channels;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 验证write写入的是buffer的remaining
 */
public class Test1_1 {

    public static void main(String[] args) throws IOException {

        FileOutputStream fosRef = new FileOutputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/nio_soket_programming_technical/src/main/java/nio/channels/a.txt"));
        FileChannel fileChannel = fosRef.getChannel();

        try{

            ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
            ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());
            System.out.println("A fileChannel.position=" + fileChannel.position());
            System.out.println("write() 1 返回值：" + fileChannel.write(buffer1));
            System.out.println("B fileChannel.position=" + fileChannel.position());

            buffer2.position(1);
            buffer2.limit(3);
            System.out.println(buffer2);

            fileChannel.position(2);
            fileChannel.write(buffer2);

        }catch (IOException e){
            e.printStackTrace();
        }
        fileChannel.close();
        fosRef.close();


    }
}
