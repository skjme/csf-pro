package ch03.pipe_input_output;

import java.io.PipedInputStream;

public class ThreadRead extends Thread {

    private ReadData readService;
    private PipedInputStream inputStream;

    public ThreadRead(ReadData readService, PipedInputStream inputStream) {
        this.readService = readService;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        readService.readData(inputStream);
    }
}
