package nio.channels;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test13_7 {

    // 共享锁别人不能写
    public static void main(String[] args) {

        try{
            RandomAccessFile fileB = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
            FileChannel fileChannelB = fileB.getChannel();
            fileChannelB.lock(6, 2, true);
            fileChannelB.write(ByteBuffer.wrap("1".getBytes()));
            fileChannelB.write(ByteBuffer.wrap("2".getBytes()));
            fileChannelB.write(ByteBuffer.wrap("3".getBytes()));
            fileChannelB.write(ByteBuffer.wrap("4".getBytes()));
            fileChannelB.write(ByteBuffer.wrap("5".getBytes()));
            fileChannelB.write(ByteBuffer.wrap("6".getBytes()));
            fileChannelB.write(ByteBuffer.wrap("7".getBytes()));

            fileB.close();
            fileChannelB.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
