package com.ioc;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-30 18:11
 */
public class MyProxy implements InvocationHandler {

    private Object object;

    private Before before;

    private After after;

    public MyProxy(Object object) {
        this.object = object;
    }

    public void setBefore(Before before) {
        this.before = before;
    }

    public void setAfter(After after) {
        this.after = after;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before.print();
        Object invoke = method.invoke(object, args);
        after.print();
        return invoke;
    }

    public Object getProxy() {
        Object proxyInstance = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new MyProxy(object));
        return proxyInstance;
    }

}
