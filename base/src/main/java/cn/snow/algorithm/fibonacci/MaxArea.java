package cn.snow.algorithm.fibonacci;

import java.util.Random;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-07-20 18:39
 */
public class MaxArea {

  public static void main(String[] args) {
    int len = 5;
    Node[] arr = genArr(len);
    Node start = arr[0], end = arr[1];
    int area = (end.index - start.index) * Math.min(end.val, start.val);
    for (int i = 0; i < arr.length - 1; i++) {
      Node startT = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        Node endT = arr[j];
        int areaT = (endT.index - startT.index) * Math.min(endT.val, startT.val);
        System.out.println(startT.index + ">>>" + endT.index + " == " + areaT);
        if (areaT > area) {
          area = areaT;
          start = startT;
          end = endT;
        }
      }
    }
    System.out.println("start >>> " + start);
    System.out.println("end >>> " + end);
  }


  public static Node[] genArr(int n) {
    Random random = new Random();
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(i, random.nextInt(10) + 1);
      System.out.println(nodes[i]);
    }
    return nodes;
  }

  static class Node {
    int index;
    int val;

    public Node(int index, int val) {
      this.index = index;
      this.val = val;
    }

    @Override
    public String toString() {
      return index+"-"+val;
    }
  }

}
