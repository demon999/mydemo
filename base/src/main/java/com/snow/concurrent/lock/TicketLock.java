package com.snow.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自旋锁
 * Ticket锁主要解决的是访问顺序的问题，主要的问题是在多核cpu上
 *
 * 每次都要查询一个serviceNum 服务号，影响性能（必须要到主内存读取，并阻止其他cpu修改）。
 */
public class TicketLock {
    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();
    private static final ThreadLocal<Integer> LOCAL = new ThreadLocal<Integer>();

    public void lock() {
        int myticket = ticketNum.getAndIncrement();
        LOCAL.set(myticket);
        while (myticket != serviceNum.get()) {
        }
    }

    public void unlock() {
        int myticket = LOCAL.get();
        serviceNum.compareAndSet(myticket, myticket + 1);
    }
}

