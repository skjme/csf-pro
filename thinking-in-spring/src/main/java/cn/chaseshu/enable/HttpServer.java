package cn.chaseshu.enable;

import org.springframework.stereotype.Component;

@Component
public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("HttpServer");
    }
}
