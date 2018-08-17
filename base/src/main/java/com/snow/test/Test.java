package com.snow.test;

public class Test {

    public static void main(String[] args) {
        A a1 = new A();

//        System.out.println(a1.i);
//        System.out.println(a2.i);

        Test test = new Test();
        System.out.println(test.FindNextPrime(11));
    }

    public int FindNextPrime(int i) {
        boolean prime = true;
        for (int j = 2; j <= Math.sqrt(i + 1); j++) {
            if ((i + 1) % j == 0) {
                prime = false;
                break;
            }
        }
        if (prime) {
            return i + 1;
        }
        return FindNextPrime(i + 1);
    }

    static A a2 = new A();

}

class A {
    A() { i = (j++ != 0) ? ++j : --j; }
    public int i;
    public static int j = 0;

    // i = 0, j = 0
    //
}

