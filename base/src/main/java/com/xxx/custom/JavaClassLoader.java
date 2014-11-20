package com.xxx.custom;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Richard on 14-11-20.
 */
public class JavaClassLoader extends ClassLoader {

    public void invokeClassMethod(String classBinName, String methodName) {
        try {
            // Create a new JavaClassLoader
            ClassLoader classLoader = this.getClass().getClassLoader();
            // Load the target class using its binary name
            Class loadedMyClass = classLoader.loadClass(classBinName);
            System.out.println("Loaded class name: " + loadedMyClass.getName());
            // Create a new instance from the loaded class
            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();
            // Getting the target method from the loaded class and invoke it using its name
            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
