package nio.channels;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test12TransferFrom {

    public static void main(String[] args) throws Exception {
        RandomAccessFile fileA = new RandomAccessFile("/Users/ask123/Desktop/a.txt", "rw");
        RandomAccessFile fileB = new RandomAccessFile("/Users/ask123/Desktop/b.txt", "rw");

        FileChannel fileChannel1 = fileA.getChannel();
        FileChannel fileChannel2 = fileB.getChannel();
        fileChannel2.position(2);

//        fileChannel1.write(ByteBuffer.wrap("abcdefg".getBytes()));
//        fileChannel2.write(ByteBuffer.wrap("123456789".getBytes()));
//
//        fileChannel2.position(8);
//        fileChannel1.transferTo(3, 4, fileChannel2);

        System.out.println("A postion=" + fileChannel1.position());
        fileChannel1.transferFrom(fileChannel2, 0, 1000);
        System.out.println("B postion=" + fileChannel1.position());

        fileChannel1.close();
        fileChannel2.close();
    }
}
