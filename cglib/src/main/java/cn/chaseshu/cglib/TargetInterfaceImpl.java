package cn.chaseshu.cglib;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Log
public class TargetInterfaceImpl implements TargetInterface {

    @Override
    public String sayHello(String name) {
        log.info("hello " + name);
        return "hello " + name;
    }

    @Override
    public String sayThanks(String name) {
        log.info("thanks " + name);
        return "thanks " + name;
    }
}
