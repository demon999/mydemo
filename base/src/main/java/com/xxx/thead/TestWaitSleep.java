package com.xxx.thead;

public class TestWaitSleep {

    public static void main(String[] args) {
        TestWaitSleep testWaitSleep = new TestWaitSleep();
        testWaitSleep.test();
    }

    public void test() {
        System.out.println("begin our test");
        ThreadSleep sleep = new ThreadSleep();
        try {
            Thread thread1 = new Thread(sleep, "A");
            Thread thread2 = new Thread(sleep, "B");
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test is over");
    }

    class ThreadSleep implements Runnable {
        int count = 0;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " say : hello sleep !!");
            count();
        }

        public void count() {
            while (count < 100) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + " say : count is " + count);
                    try {
                        count++;
//                        Thread.sleep(100);
                        this.wait(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

}
