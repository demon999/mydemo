package cn.snow.algorithm.fibonacci;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-20 18:15
 */
public class Fibonacci {

  public static void main(String[] args) {
    for (int i = 0; i < 30; i++) {
      System.out.print(fib(i) + " ");
    }

    System.out.println();

    int a = 1;
    int b = 1;
    for (int i = 0; i < 30; i++) {
      if (i > 1) {
        int temp = b;
        b += a;
        a = temp;
      }
      System.out.print(b + " ");
    }
  }

  public static int fib(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return fib(n - 1) + fib(n - 2);
  }

}
