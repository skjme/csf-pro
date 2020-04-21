package cn.chaseshu.enable;

import org.springframework.stereotype.Component;

@Component
public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("FtpServer");
    }
}
