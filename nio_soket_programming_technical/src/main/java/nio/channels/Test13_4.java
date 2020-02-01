package nio.channels;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 验证FileLockInterruptionException异常发生
 */
public class Test13_4 {


    public static void main(String[] args) throws IOException, InterruptedException {

        FileOutputStream fileA = new FileOutputStream("/Users/ask123/Desktop/a.txt");
        FileChannel fileChannelA = fileA.getChannel();

        Thread a = new Thread(){
            @Override
            public void run() {
                try{
                    for(int i = 0; i < 1000000; i++){
                        System.out.println("i=" + (i + 1));

                    }
                    fileChannelA.lock(1, 2, false);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        a.start();
        Thread.sleep(50);

        a.interrupt(); // 先执行中断方法
        Thread.sleep(30000);

        fileA.close();
        fileChannelA.close();

    }
}
