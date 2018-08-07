package com.snow.boot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        //自定义类加载器的加载路径
        MyClassLoader myClassLoader = new MyClassLoader("D:\\lib");
        //包名+类名
        Class c = myClassLoader.loadClass("com.test.Test");

        if (c != null) {
            Object obj = c.newInstance();
            Method method = c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
}
