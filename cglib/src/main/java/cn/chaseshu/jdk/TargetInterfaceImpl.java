package cn.chaseshu.jdk;


import lombok.extern.java.Log;

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
