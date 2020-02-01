package nio.channels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test10Truncate {

    public static void main(String[] args) throws IOException {

        ByteBuffer byteBuffer = ByteBuffer.wrap("12345678".getBytes());

        FileOutputStream fos = new FileOutputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/abc.txt"));
        FileChannel fileChannel = fos.getChannel();

        fileChannel.write(byteBuffer);

        System.out.println("A size=" + fileChannel.size() +
                " position=" + fileChannel.position());

//        fileChannel.truncate(10000); // 截断缓冲区
        fileChannel.truncate(4); // 截断缓冲区
        System.out.println("A size=" + fileChannel.size() +
                " position=" + fileChannel.position());



        fileChannel.close();
        fos.flush();
        fos.close();
    }
}
