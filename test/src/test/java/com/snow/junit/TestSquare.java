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
public class TestSquare {

    private static Calculator calculator = new Calculator();
    private int param;
    private int result;

    /*
     * 定义测试数据的集合，也就是上述的data()方法，
     * 该方法可以任意命名，但是必须使用@Parameters标注进行修饰。
     * 这个方法的框架就不予解释了，大家只需要注意其中的数据，是一个二维数组，
     * 数据两两一组，每组中的这两个数据，一个是参数，一个是你预期的结果
     * */
    @Parameters
    public static Collection date() {
        return Arrays.asList(new Object[][]{
                {2, 4},
                {0, 0},
                {-3, 9},
        });
    }

    //构造函数，对变量进行初始化


    //定义一个待测试的类，并且定义两个变量，一个用于存放参数，一个用于存放期待的结果。
    public TestSquare(int param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void square() {
        System.out.println("----------->square");
        calculator.square(param);
        assertEquals(result, calculator.getResult());
    }

}
