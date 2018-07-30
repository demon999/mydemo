package com.snow.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Object instance = Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class<?>[] {MyInterface.class}, new MyInvocationHandler());
        ((MyInterface) instance).say("ccc");
    }

}

class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(proxy, args[0]);
        return null;
    }

}

interface MyInterface {
    void say(String content);
}

class MyInterfaceImpl implements MyInterface {

    @Override
    public void say(String content) {
        System.out.println(content);
    }
}

