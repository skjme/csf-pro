package nio.channels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class Test1 {

    public static void main(String[] args) throws IOException {

        FileOutputStream fosRef = new FileOutputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/nio_soket_programming_technical/src/main/java/nio/channels/a.txt"));
        FileChannel fileChannel = fosRef.getChannel();

        try{

            ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
            System.out.println("A fileChannel.position=" + fileChannel.position());
            System.out.println("write() 1 返回值：" + fileChannel.write(buffer));
            System.out.println("B fileChannel.position=" + fileChannel.position());

            fileChannel.position(2);
            buffer.rewind(); // 还原buffer的position为0

            System.out.println("write() 2 返回值：" + fileChannel.write(buffer));
            System.out.println("C fileChannel.position=" + fileChannel.position());

        }catch (IOException e){
            e.printStackTrace();
        }
        fileChannel.close();
        fosRef.close();


    }
}
