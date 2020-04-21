package cn.chaseshu.enable;

public interface Server {

    void start();
    enum ServerType{
        HTTP,
        FTP
    }
}
