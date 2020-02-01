package nio.channels;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test13_20 {

    // 共享锁、独占锁 是非互斥关系
    // 共享锁与共享锁非互斥关系，其他均为互斥关系
    public static void main(String[] args) {

        try{
            RandomAccessFile fileB = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
            FileChannel fileChannelB = fileB.getChannel();
//            fileChannelB.lock(0, Integer.MAX_VALUE, true); // 共享锁
            fileChannelB.lock(0, Integer.MAX_VALUE, false); // 独占锁

            Thread.sleep(Integer.MAX_VALUE);

            fileB.close();
            fileChannelB.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
