package com.snow.junit;

import org.junit.*;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 14-6-23.
 */
//@RunWith(CustomTestRunner.class)
public class TestWordDealUtil {

    // 类级别 Fixture 初始化方法
    @BeforeClass
    public static void dbInit() {
        System.out.println("------->BeforeClass");
    }

    // 类级别 Fixture 注销方法
    @AfterClass
    public static void dbClose(){
        System.out.println("------->AfterClass");
    }

    // 初始化 Fixture 方法
    @Before
    public void init() {
        System.out.println("------->Before");
    }

    // 注销 Fixture 方法
    @After
    public void destroy(){
        System.out.println("------->After");
    }

    // 测试 wordFormat4DB 正常运行的情况
    @Test
    public void wordFormat4DBNormal(){
        System.out.println("------->wordFormat4DBNormal");
        String target = "employeeInfo";
        String result = WordDealUtil.wordFormat4DB(target);

        Assert.assertEquals("employee_info", result);
    }

    // 测试 null 时的处理情况
    // (expected = java.lang.NullPointerException.class,timeout=10)
    @Test
    public void wordFormat4DBNull(){
        System.out.println("------->wordFormat4DBNull");
        String target = null;
        String result = WordDealUtil.wordFormat4DB(target);

        Assert.assertNull(result);
    }

    // 测试空字符串的处理情况
    @Test
    public void wordFormat4DBEmpty(){
        System.out.println("------->wordFormat4DBEmpty");
        String target = "";
        String result = WordDealUtil.wordFormat4DB(target);

        Assert.assertEquals("", result);
    }

    // 测试当首字母大写时的情况
    @Test
    public void wordFormat4DBegin(){
        System.out.println("------->wordFormat4DBegin");
        String target = "EmployeeInfo";
        String result = WordDealUtil.wordFormat4DB(target);

        Assert.assertEquals("employee_info", result);
    }

    // 测试当尾字母为大写时的情况
    @Test(timeout=10)
    public void wordFormat4DBEnd(){
        System.out.println("------->wordFormat4DBEnd");
        String target = "employeeInfoA";
        String result = WordDealUtil.wordFormat4DB(target);

        Assert.assertEquals("employee_info_a", result);
    }

    // 测试多个相连字母大写时的情况
    @Test
    @Ignore
    public void wordFormat4DBTogether(){
        System.out.println("------->wordFormat4DBTogether");
        String target = "employeeAInfo";
        String result = WordDealUtil.wordFormat4DB(target);

        Assert.assertEquals("employee_a_info", result);
    }

}
