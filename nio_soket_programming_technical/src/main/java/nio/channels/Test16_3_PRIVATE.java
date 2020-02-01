package nio.channels;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 私有模式不可更改
 */
public class Test16_3_PRIVATE {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/ask123/Desktop/a.txt"); // abcdefg
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = fileA.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.PRIVATE, 0, 5);

        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// a
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// b
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// c
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// d
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// e

        System.out.println();

        mappedByteBuffer.position(0);
        mappedByteBuffer.put((byte) 'o');
        mappedByteBuffer.put((byte) 'p');
        mappedByteBuffer.put((byte) 'q');
        mappedByteBuffer.put((byte) 'r');
        mappedByteBuffer.put((byte) 's');

        fileChannel.close();
        fileA.close();
    }
}
