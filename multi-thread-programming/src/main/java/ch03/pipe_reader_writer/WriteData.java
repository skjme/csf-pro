package ch03.pipe_reader_writer;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteData {

    // Piped character-output streams
    public void writeMethod(PipedWriter out){

        try{
            System.out.println("write :");
            for(int i = 0; i < 300;i++){
                String outData = "" + (i+1);
                out.write(outData);
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
