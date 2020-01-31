package nio.channels;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test2_4 {


    private static FileInputStream fisRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException, InterruptedException {

        fisRef = new FileInputStream(new File("/Users/ask123/OpenSourceCode/csf-pro/" +
                "nio_soket_programming_technical/src/main/java/nio/channels/b.txt"));

        fileChannel = fisRef.getChannel();

        // 1 ByteBuffer缓冲区remaining为多少，就从通道中读取多少
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);

        System.out.println("A:" + fileChannel.position());
        fileChannel.read(byteBuffer);
        System.out.println("B:" + fileChannel.position());

//        fileChannel.close();
//        fisRef.close();

        byteBuffer.rewind();

        for(int i = 0; i < byteBuffer.limit(); i++){
            System.out.print((char)byteBuffer.get());
        }
        System.out.println();
        System.out.println();

        // 2 从通道中读取的字节放入缓冲区的remaining空间中
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(100);
        byteBuffer2.position(1);
        byteBuffer2.limit(3);
        System.out.println("C:" + fileChannel.position());
        fileChannel.position(0);
        System.out.println("D:" + fileChannel.position());
        fileChannel.read(byteBuffer2);
        fileChannel.close();
        fisRef.close();

        byteBuffer2.rewind();

        for(int i = 0; i < byteBuffer2.limit(); i++){
//            System.out.print((char)byteBuffer2.get());
            byte eachByte = byteBuffer2.get();
            if(eachByte == 0){
                System.out.print("空格");
            }else{
                System.out.print((char)eachByte);
            }
        }

    }
}
