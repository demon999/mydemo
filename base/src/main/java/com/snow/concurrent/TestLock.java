package com.snow.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        testLock.test();
    }

    public void test() {
        final ExecutorService exec = Executors.newFixedThreadPool(4);
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        final int time = 5;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Pre " + lock);
                lock.lock();
                try {
//                    condition.await(time, TimeUnit.SECONDS);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Post " + lock.toString());
                    lock.unlock();
                }
            }
        };

        for(int index = 0; index < 4; index++) {
            exec.submit(runnable);
        }
        exec.shutdown();
    }
}
