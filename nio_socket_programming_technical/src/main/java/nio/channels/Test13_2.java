package nio.channels;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        RandomAccessFile fileA = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
        FileChannel fileAChannelA = fileA.getChannel();

        System.out.println("B Begin");
        fileAChannelA.lock(1, 2, false);
        System.out.println("B end");

        Thread.sleep(Integer.MAX_VALUE);

        fileA.close();
        fileAChannelA.close();

    }
}
