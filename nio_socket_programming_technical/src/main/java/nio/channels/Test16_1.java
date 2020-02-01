package nio.channels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;

public class Test16_1 {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/ask123/Desktop/a.txt"); // abcdefg
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = fileA.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, 5);

        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// a
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// b
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// c
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// d
        System.out.println((char)mappedByteBuffer.get() + " position=" + mappedByteBuffer.position());// e

        System.out.println();

        // 超出映射范围，抛出异常
        try {
            System.out.println((char) mappedByteBuffer.get() + " position=" + mappedByteBuffer.position()); // throws java.nio.BufferUnderflowException
        }catch (BufferUnderflowException e){
            e.printStackTrace();
        }

        MappedByteBuffer mappedByteBuffer2 = fileChannel.map(FileChannel.MapMode.READ_ONLY, 2, 2);
        System.out.println((char)mappedByteBuffer2.get() + " position=" + mappedByteBuffer2.position());// c
        System.out.println((char)mappedByteBuffer2.get() + " position=" + mappedByteBuffer2.position());// d
        // 超出映射范围，抛出异常
        try{
            System.out.println((char)mappedByteBuffer2.get() + " position=" + mappedByteBuffer2.position());// throws java.nio.BufferUnderflowException
        }catch (BufferUnderflowException e){
            e.printStackTrace();
        }

        // 测试只读模式，不可以写
        try{
            mappedByteBuffer2.putChar('1');
        }catch (ReadOnlyBufferException e){
            e.printStackTrace();
        }

        fileChannel.close();
        fileA.close();
    }
}
