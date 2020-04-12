package cn.chaseshu.proxy;

// 静态代理、代码冗余
public class TargetProxy implements TargetInterface {

    private TargetInterface targetInterface;

    public TargetProxy(TargetInterface targetInterface) {
        this.targetInterface = targetInterface;
    }

    @Override
    public String sayHello(String name) {

        // 限流
        System.out.println("sayHello服务限流");

        return targetInterface.sayHello(name);
    }

    @Override
    public String sayThanks(String name) {

        // 限流
        System.out.println("sayThanks服务限流");

        return targetInterface.sayThanks(name);
    }
}
