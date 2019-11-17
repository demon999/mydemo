package com.ioc;


import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-30 18:08
 */
public class AppContext {

    public ConcurrentMap<String, Object> beans = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        Object o = beans.get(name);
        if (o == null) {
            return createBean(name);
        }
        return o;
    }

    public Object createBean(String className) {
        try {
            Class clazz = Class.forName(className);
            MyProxy myProxy = new MyProxy(clazz.newInstance());
            myProxy.setBefore(() -> {
                System.out.println("before");
            });
            myProxy.setAfter(() -> {
                System.out.println("after");
            });
            Object proxy = myProxy.getProxy();
            beans.put(className, proxy);
            return proxy;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
