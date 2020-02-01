package nio.channels;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_21 {

    // 共享锁、独占锁 是非互斥关系
    // 共享锁与共享锁非互斥关系，其他均为互斥关系
    public static void main(String[] args) {

        try{
            RandomAccessFile fileB = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
            FileChannel fileChannelB = fileB.getChannel();
            System.out.println("begin");
//            fileChannelB.lock(0, Integer.MAX_VALUE, true);
//            System.out.println("end 拿到共享锁了");
            fileChannelB.lock(0, Integer.MAX_VALUE, false);
//            fileChannelB.lock();
            System.out.println("end 拿到锁了");

            fileB.close();
            fileChannelB.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
