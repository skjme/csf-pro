package nio.channels;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  读操作，
 *  1 验证是从通道Channel当前位置开始读取的，
 *  2 验证是将字节放入缓冲区Buffer当前位置，
 */
public class Test2_2 {

    private static FileInputStream fisRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException, InterruptedException {

        fisRef = new FileInputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/b.txt"));
        fileChannel = fisRef.getChannel();

        // 验证 read() 将从fileChannel通道当前位置开始读取
        fileChannel.position(2);
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        int readLength = fileChannel.read(byteBuffer);
        System.out.println(readLength);

        byte[] getByteArray = byteBuffer.array();
        for (int i = 0; i < getByteArray.length; i++){
            System.out.print((char)getByteArray[i] + " ");
        }


        // read() 将字节放入ByteBuffer的当前位置（position=3）
        System.out.println();
        System.out.println();
        fileChannel.position(2);
        byteBuffer.position(3);
        fileChannel.read(byteBuffer);
        getByteArray = byteBuffer.array();
        for (int i = 0; i < getByteArray.length; i++){
            System.out.print((char)getByteArray[i] + " ");
        }

        fileChannel.close();
        fisRef.close();
    }
}
