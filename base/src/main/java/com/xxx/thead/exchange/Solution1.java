package com.xxx.thead.exchange;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-14 23:13
 */
public class Solution1 {
    private static Object object = new Object();
    private static boolean isFlag = false;
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 999; i++) {
                synchronized (object) {
                    if (!isFlag) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("current t1:" + i);
                        isFlag = false;
                        object.notifyAll();
                    }
//                    if (!isFlag) {
//                        System.out.println("current t1:" + i);
//                        isFlag = true;
//                        try {
//                            object.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("t1 >>> " + i);
//                        object.notifyAll();
//                        System.out.println("t1 >>> " + i);
//                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                synchronized (object) {
                    if (isFlag) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("current t2:" + i);
                        isFlag = true;
                        object.notifyAll();
                    }
//                    if (isFlag) {
//                        System.out.println("current t2:" + i);
//                        isFlag = false;
//                        object.notifyAll();
//                        System.out.println("t2 >>> " + i);
//                        try {
//                            object.wait();
//                            System.out.println("t2 >>> " + i);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
                }
            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }

}
