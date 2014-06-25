package com.snow.test;

import junit.framework.TestCase;

/**
 * Created by xueliming on 14-6-22.
 */
public class TestCalcuator2 extends TestCase {
    public void testAdd(){
        Calcuator calcuator=new Calcuator();
        double result=calcuator.add(1,2);
        assertEquals(3,result,0);
    }
}
