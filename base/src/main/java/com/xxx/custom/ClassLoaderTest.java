package com.xxx.custom;

/**
 * Created by Richard on 14-11-20.
 */
public class ClassLoaderTest  {
    public static void main(String[] args) {
        JavaClassLoader javaClassLoader = new JavaClassLoader();
        javaClassLoader.invokeClassMethod("com.xxx.custom.MyClass", "sayHello");
    }

}
