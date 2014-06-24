package com.snow.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Administrator on 14-6-23.
 */
@RunWith(Parameterized.class)
public class TestWordDealUtilWithParam {

    private String expected;

    private String target;

    @Parameters
    public static Collection words(){
        return Arrays.asList(new Object[][]{
                {"employee_info", "employeeInfo"},      // 测试一般的处理情况
                {null, null},                           // 测试 null 时的处理情况
                {"", ""},                               // 测试空字符串时的处理情况
                {"employee_info", "EmployeeInfo"},      // 测试当首字母大写时的情况
                {"employee_info_a", "employeeInfoA"},   // 测试当尾字母为大写时的情况
                {"employee_a_info", "employeeAInfo"}    // 测试多个相连字母大写时的情况
        });
    }

    /**
     * 参数化测试必须的构造函数
     * @param expected     期望的测试结果，对应参数集中的第一个参数
     * @param target     测试数据，对应参数集中的第二个参数
     */
    public TestWordDealUtilWithParam(String expected , String target){
        this.expected = expected;
        this.target = target;
    }

    /**
     * 测试将 Java 对象名称到数据库名称的转换
     */
    @Test
    public void wordFormat4DB(){
        System.out.println("---------->wordFormat4DB");
        assertEquals(expected, WordDealUtil.wordFormat4DB(target));
    }

}
