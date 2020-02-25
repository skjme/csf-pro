package ch03.pipe_reader_writer;



import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 通过管道pipe进行线程间通信：字符流 character streams
 */
public class Run {

    public static void main(String[] args) {

        try{
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedReader inputStream = new PipedReader();
            PipedWriter outputStream = new PipedWriter();

            inputStream.connect(outputStream);
//            outputStream.connect(inputStream);

            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();

            ThreadRead.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
