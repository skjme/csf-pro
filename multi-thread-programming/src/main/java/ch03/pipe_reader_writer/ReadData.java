package ch03.pipe_reader_writer;

import java.io.IOException;
import java.io.PipedReader;

public class ReadData {

    // Piped character-input streams
    public void readMethod(PipedReader inputStream){

        try{
            System.out.println("read :");
            char[] charArray = new char[20];
            int readLength = inputStream.read(charArray);
            while(readLength != -1){
                String newData = new String(charArray, 0, readLength);
                System.out.print(newData);
                readLength = inputStream.read(charArray);
            }
            System.out.println();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
