package nio.channels;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * force
 */
public class Test16_5_force {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/ask123/Desktop/a.txt"); // abcdefg
        File dir = new File("/Users/ask123/Desktop/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        RandomAccessFile fileA = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = fileA.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 100);

       long beginTime = System.currentTimeMillis();

       for(int i = 0; i < 100; i++){
           mappedByteBuffer.put("a".getBytes());
           mappedByteBuffer.force();
       }

       long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);

        System.out.println(mappedByteBuffer.isLoaded());
        mappedByteBuffer.load();
        System.out.println(mappedByteBuffer.isLoaded());
        System.out.println(mappedByteBuffer.isDirect());
        System.out.println(mappedByteBuffer.isReadOnly());

        fileChannel.close();
        fileA.close();
    }
}
