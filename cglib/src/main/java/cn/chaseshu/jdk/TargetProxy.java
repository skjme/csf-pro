package cn.chaseshu.jdk;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.invoke.CallSite;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// jdk自带代理类实现

/**
 * TargetProxy不是真正的代理类，而是代理类的一部分
 */
public class TargetProxy implements InvocationHandler {

    /**
     * 持有目标接口类的引用
     */
    private Object target;

    public TargetProxy(Object target) {
        this.target = target;
    }

    /**
     * 获取真正的代理类
     * @param interfaces
     * @param <T>
     * @return
     */
    public <T> T getProxy(Class interfaces){
        return (T)Proxy.newProxyInstance(
                interfaces.getClassLoader(),
                new Class<?>[]{interfaces},
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + " 数据缓存。。。。");

        // 调用目标方法
        return method.invoke(target, args);
    }
}
