package cn.chaseshu.cglib;


import lombok.extern.java.Log;
import net.sf.cglib.core.DebuggingClassWriter;

import java.util.Properties;

@Log
public class Test {

    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/ask123/Desktop");

        TargetProxy targetProxy = new TargetProxy();

//        TargetInterfaceImpl targetInterface = targetProxy.getProxy(TargetInterfaceImpl.class);

//        targetInterface.sayHello("zhangsan");
//        targetInterface.sayThanks("zhangsan");

        UserService proxy = targetProxy.getProxy(UserService.class);
        log.info(proxy.getClass().toGenericString());

        proxy.sleeping(); // final类与final方法，无法进行代理
        proxy.thinking();


    }
}
