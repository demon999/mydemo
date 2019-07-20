package cn.snow.algorithm.fibonacci;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-20 18:33
 */
public class Step {

  public static void main(String[] args) {
    System.out.println(">>> " + getN(10));
  }

  public static int getN(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return getN(n - 1) + getN(n - 2);
  }

}
