package com.snow.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

    public static void main(String[] args) {
        // ProxyGenerator
        MyJdkProxy myJdkProxy = new MyJdkProxy();
        MyInterface jdkProxy = (MyInterface) myJdkProxy.getJdkProxy(new MyInterfaceImpl());
        jdkProxy.say("world!");
    }

}

class MyJdkProxy implements InvocationHandler {
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

    //定义获取代理对象方法
    public Object getJdkProxy(Object targetObject){
        //为目标对象target赋值
        this.target = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

}



