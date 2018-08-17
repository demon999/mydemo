package com.snow.disruptor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class LongEventThreadFactory implements ThreadFactory {
    private AtomicLong atomicLong = new AtomicLong(0);
    private ThreadGroup threadGroup;

    public LongEventThreadFactory(String name) {
        threadGroup = new ThreadGroup(name);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(threadGroup, r);
        t.setName(threadGroup.getName() + "-" + atomicLong.getAndIncrement());
        t.setDaemon(true);
        return t;
    }
}
