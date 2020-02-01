package nio.channels;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Test14_1 {

    // 独占锁
    public static void main(String[] args) {

        try{
            RandomAccessFile fileB = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
            FileChannel fileChannelB = fileB.getChannel();
            FileLock fileLock = fileChannelB.tryLock(0, 5, false);

//            fileLock.release();
//            fileLock.isShared();
            System.out.println(fileLock.isValid());
            System.out.println("end 拿到独占锁了");
            Thread.sleep(Integer.MAX_VALUE);

            fileB.close();
            fileChannelB.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
