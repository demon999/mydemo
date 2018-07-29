package com.snow.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + " start >>>");
                ThreadLocalRandom current = ThreadLocalRandom.current();
                for(int i = 0; i < 10; i++) {
                    System.out.println(thread.getName() + "::" + current.nextLong(10000));
                }
                System.out.println(thread.getName() + " end <<<");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(t);
        }
    }

}
