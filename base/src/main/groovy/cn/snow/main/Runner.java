package cn.snow.main;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;

import java.io.File;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 05/16/2015
 * @description
 */
public class Runner {

    private static String filePath = "E:\\Workspace\\mydemo\\base\\src\\main\\groovy\\cn\\snow\\sample\\Hello.groovy";

    static void runWithGroovyShell() throws Exception {
        new GroovyShell().parse(new File(filePath)).invokeMethod("helloWorld", null);
    }

    static void runWithGroovyClassLoader() throws Exception {
        // Declaring a class to conform to a java interface class would get rid of
        // a lot of the reflection here
        Class scriptClass = new GroovyClassLoader().parseClass(new File(filePath));
        Object scriptInstance = scriptClass.newInstance();
        scriptClass.getDeclaredMethod("helloWorld", new Class[]{}).invoke(scriptInstance, new Object[]{});
    }

    static void runWithGroovyScriptEngine() throws Exception {
        // Declaring a class to conform to a java interface class would get rid of
        // a lot of the reflection here
        Class scriptClass = new GroovyScriptEngine(".").loadScriptByName("Hello.groovy");
        Object scriptInstance = scriptClass.newInstance();
        scriptClass.getDeclaredMethod("helloWorld", new Class[]{}).invoke(scriptInstance, new Object[]{});
    }

    public static void main(String[] args) throws Exception {
        runWithGroovyShell();
        runWithGroovyClassLoader();
        runWithGroovyScriptEngine();
    }
}
