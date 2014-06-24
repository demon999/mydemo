package com.snow.testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created by Administrator on 14-6-23.
 */
public class TestSimple {

    @Test
    public void testAdd() {
        System.out.println("TestSimple------------------>testAdd");
        String str = "TestNG is working fine";
        assertEquals("TestNG is working fine", str);
    }

}
