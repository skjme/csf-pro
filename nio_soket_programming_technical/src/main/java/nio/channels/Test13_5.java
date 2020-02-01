package nio.channels;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test13_5 {

    // 共享锁自己不能写
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
        FileChannel fileChannelA = fileA.getChannel();

        fileChannelA.lock(1, 2, true);
        fileChannelA.write(ByteBuffer.wrap("q234567890".getBytes()));
;

        fileA.close();
        fileChannelA.close();


    }
}
