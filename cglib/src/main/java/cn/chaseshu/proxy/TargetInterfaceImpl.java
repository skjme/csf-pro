package cn.chaseshu.proxy;

public class TargetInterfaceImpl implements TargetInterface {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String sayThanks(String name) {
        return "thanks " + name;
    }
}
