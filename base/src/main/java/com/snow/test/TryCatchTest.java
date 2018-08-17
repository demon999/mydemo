package com.snow.test;

public class TryCatchTest {

    public static void main(String[] args) {
        TryCatchTest tryCatchTest = new TryCatchTest();
        System.out.println(tryCatchTest.test());
    }

    public int test() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
//        return 0;
    }

}
