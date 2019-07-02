package com.snow.concurrent;

import java.util.concurrent.*;

public class TestSemaphore {

    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = () -> {
                try {
                    // 获取许可
                    semp.acquire();
                    System.out.println("Accessing: " + NO);
                    Thread.sleep((long) (Math.random() * 1000));
                    // 访问完后，释放
                    semp.release();
                    System.out.println("-----------------" + semp.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
}
