package nio.channels;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockAPI_2 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ask123/Desktop/a.txt");
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel fileChannelA = fileA.getChannel();

        FileLock lock = fileChannelA.lock(1, 10, true);
        System.out.println(lock.overlaps(5, 10)); // 至少重叠一个字节时就返回true
        System.out.println(lock.overlaps(11, 12)); // 否则false
        lock.close();

    }
}
