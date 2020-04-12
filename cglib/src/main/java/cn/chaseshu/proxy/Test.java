package cn.chaseshu.proxy;

public class Test {

    public static void main(String[] args) {
        TargetProxy proxy = new TargetProxy(new TargetInterfaceImpl());

        proxy.sayHello("zhangsan");
        proxy.sayThanks("zhangsan");
    }
}
