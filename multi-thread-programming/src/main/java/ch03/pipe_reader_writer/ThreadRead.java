package ch03.pipe_reader_writer;

import java.io.PipedReader;

public class ThreadRead extends Thread {

    private ReadData read;
    private PipedReader inputStream;

    public ThreadRead(ReadData read, PipedReader inputStream) {
        this.read = read;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        read.readMethod(inputStream);
    }
}
