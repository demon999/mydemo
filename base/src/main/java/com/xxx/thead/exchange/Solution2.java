package com.xxx.thead.exchange;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-10-14 23:15
 */
public class Solution2 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        // thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 999; i += 2) {
                lock.lock();
                try {
                    System.out.println("current t1:" + i);
                    condition1.await();
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });

        // thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 1000; i += 2) {
                lock.lock();
                try {
                    System.out.println("current t2:" + i);
                    condition1.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();

            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
