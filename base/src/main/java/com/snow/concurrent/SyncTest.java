package com.snow.concurrent;

public class SyncTest {

    private final Object lock = new Object();

    public void sync(){
        synchronized (lock) {
            System.out.println("lock start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock end");
        }
    }

}
