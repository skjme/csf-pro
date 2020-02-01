package nio.channels;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test13_6 {

    // 共享锁别人不能写
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
        FileChannel fileChannelA = fileA.getChannel();

//        fileChannelA.lock(1, 2, true); // 共享锁
        fileChannelA.lock(1, 2, false); // 独占锁

        Thread.sleep(Integer.MAX_VALUE);

        fileA.close();
        fileChannelA.close();

    }
}
