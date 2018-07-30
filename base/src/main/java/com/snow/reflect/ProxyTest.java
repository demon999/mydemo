package com.snow.reflect;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Object instance = Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), null, null);
    }

}
