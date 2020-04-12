package cn.chaseshu.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// 使用cglib 实现动态代理
/**
 * TargetProxy不是真正的代理类，而是代理类的一部分
 */
public class TargetProxy implements MethodInterceptor {

    /**
     * 获取真正的代理类
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getProxy(Class clazz){

        // 字节码增强类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(clazz);

        // 设置回调类
        enhancer.setCallback(this);

        return (T) enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName() + "服务限流。。。。");
        // 调用目标方法
        return methodProxy.invokeSuper(obj, args);
    }
}
