package nio.channels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  读操作
 *  返回值：
 *  正数 代表读取的字节个数
 *  0 没有读取任何值
 *  -1代表达到流的末端
 */
public class Test2_1 {

    private static FileInputStream fisRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException, InterruptedException {

        fisRef = new FileInputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/b.txt"));
        fileChannel = fisRef.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        int readLength = fileChannel.read(byteBuffer);
        System.out.println(readLength);

        //byteBuffer.clear();
        readLength = fileChannel.read(byteBuffer);
        System.out.println(readLength);

        byteBuffer.clear();
        readLength = fileChannel.read(byteBuffer);
        System.out.println(readLength);

        fileChannel.close();
        fisRef.close();
    }
}
