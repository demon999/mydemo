package com.snow.junit;

/**
 * Created by Administrator on 14-6-23.
 */
public class Calculator {

    private static int result;

    public void add(int n) {
        result = result + n;
    }

    public void substract(int n) {
        result = result - n;
    }

    public void multiply(int n) {
        result = result * n;
    }

    public void divide(int n) {
        result = result / n;
    }

    public void square(int n) {
        result = n * n;
    }

//    public void squareRoot(int n) {
//        for (; ; ) ;            //Bug : 死循环
//    }

    public void clear() {     // 将结果清零
        result = 0;
    }

    public int getResult() {
        return result;
    }
}
