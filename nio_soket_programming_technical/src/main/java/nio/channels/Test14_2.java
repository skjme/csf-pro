package nio.channels;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Test14_2 {

    // 独占锁
    public static void main(String[] args) {

        try{
            RandomAccessFile fileB = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
            FileChannel fileChannelB = fileB.getChannel();

            FileLock fileLock = fileChannelB.tryLock(0, 5, false);
//            FileLock fileLock = fileChannelB.tryLock(0, 5, true);

            if(null == fileLock){
                System.out.println("end 未拿到锁");
            }else{
                System.out.println(fileLock);
                System.out.println("end 拿到独占锁了");
            }


            fileB.close();
            fileChannelB.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
