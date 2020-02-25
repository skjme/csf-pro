package ch03.pipe_input_output;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {

    private WriteData writeService;
    private PipedOutputStream outputStream;

    public ThreadWrite(WriteData writeService, PipedOutputStream outputStream) {
        this.writeService = writeService;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        writeService.writeMethod(outputStream);
    }
}
