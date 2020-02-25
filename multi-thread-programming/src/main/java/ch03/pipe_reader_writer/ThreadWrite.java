package ch03.pipe_reader_writer;

import java.io.PipedWriter;

public class ThreadWrite extends Thread {

    private WriteData write;
    private PipedWriter outputStream;

    public ThreadWrite(WriteData write, PipedWriter outputStream) {
        this.write = write;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        write.writeMethod(outputStream);
    }
}
