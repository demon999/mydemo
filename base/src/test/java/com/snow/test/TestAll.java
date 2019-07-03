package com.snow.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Created by richard.xue on 14-6-22.
 */
public class TestAll extends TestSuite {
    public static Test suite() {
        TestSuite suite = new TestSuite("TestSuite Test");
        suite.addTestSuite(TestCalcuator.class);
        suite.addTestSuite(TestCalcuator2.class);
        return suite;
    }
    public static void main(String args[]){
        TestRunner.run(suite());
    }
}
