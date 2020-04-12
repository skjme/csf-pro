package cn.chaseshu.jdk;

import lombok.extern.java.Log;

@Log
public class Test {

    public static void main(String[] args) {

        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        TargetProxy targetProxy = new TargetProxy(new TargetInterfaceImpl());
        TargetInterface targetInterface = targetProxy.getProxy(TargetInterface.class);
        log.info(targetInterface.getClass().toGenericString());
        System.out.println(targetInterface.sayHello("zhangshansayhello..."));

    }
}
