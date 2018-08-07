package com.snow.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest2 {

    public void sync(){
        System.out.println("lock start");
        ReentrantLock lock = new ReentrantLock();
//        lock.lock();
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
        lock.unlock();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("lock end");
    }

}
