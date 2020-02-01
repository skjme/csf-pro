package nio.channels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockAPI_1 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ask123/Desktop/a.txt");
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel fileChannelA = fileA.getChannel();
        System.out.println("fileChannelA.hashCode=" + fileChannelA.hashCode());

        FileLock lock = fileChannelA.lock(1, 10, true);
        System.out.println("A position=" + lock.position() + " size=" + lock.size()
        + " isValid=" + lock.isValid() + " isShared=" + lock.isShared()
        + " channel().hashcode()=" + lock.channel().hashCode()
        + " acquiredBy().hashcode()=" + lock.acquiredBy().hashCode());
        lock.release();
        lock = fileChannelA.lock(1, 10, false);
        System.out.println("B position=" + lock.position() + " size=" + lock.size()
                + " isValid=" + lock.isValid() + " isShared=" + lock.isShared()
                + " channel().hashcode()=" + lock.channel().hashCode()
                + " acquiredBy().hashcode()=" + lock.acquiredBy().hashCode());
        lock.close();
        fileChannelA.close();
        System.out.println("C position=" + lock.position() + " size=" + lock.size()
                + " isValid=" + lock.isValid() + " isShared=" + lock.isShared()
                + " channel().hashcode()=" + lock.channel().hashCode()
                + " acquiredBy().hashcode()=" + lock.acquiredBy().hashCode());
    }
}
