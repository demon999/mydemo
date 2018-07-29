package com.snow.concurrent.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }

    public static void main(String[] args) {
        System.out.println(">>>");
        SpinLock spinLock = new SpinLock();
        spinLock.lock();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        spinLock.unlock();
        System.out.println("<<<");
    }

}
