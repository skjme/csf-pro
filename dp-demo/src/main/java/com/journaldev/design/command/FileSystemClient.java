package com.journaldev.design.command;

public class FileSystemClient {

    public static void main(String[] args) {

        // 1 Creating the receiver object
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

        // 2 creating command and associating with receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);

        // 3 creating invoker and associatiing with command
        FileInvoker file = new FileInvoker(openFileCommand);

        // 4 perform action on invoker object
        file.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        file = new FileInvoker(writeFileCommand);
        file.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        file = new FileInvoker(closeFileCommand);
        file.execute();

    }
}
