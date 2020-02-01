package nio.channels;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;

public class Test16_2_READ_WRITE {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/ask123/Desktop/a.txt"); // abcdefg
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = fileA.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 10);

        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// a
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// b
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// c
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// d
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// e

        System.out.println();

        mappedByteBuffer.position(0);
        mappedByteBuffer.putChar('1'); //  char 占 2字节
        mappedByteBuffer.putChar('2');
        System.out.println(mappedByteBuffer.position());
        mappedByteBuffer.putChar('3');
        mappedByteBuffer.putChar('4');
        mappedByteBuffer.putChar('5');

        fileChannel.close();
        fileA.close();
    }
}
