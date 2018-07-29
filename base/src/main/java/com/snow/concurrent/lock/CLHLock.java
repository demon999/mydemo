package com.snow.concurrent.lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 自旋锁
 * CLHlock是不停的查询前驱变量， 导致不适合在NUMA 架构下使用（在这种结构下，每个线程分布在不同的物理内存区域）
 */
public class CLHLock {
    public static class CLHNode {
        private volatile boolean isLocked = true;
    }

    @SuppressWarnings("unused")
    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<CLHNode>();
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(CLHLock.class,
            CLHNode.class, "tail");

    public void lock() {
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        CLHNode preNode = UPDATER.getAndSet(this, node);
        if (preNode != null) {
            while (preNode.isLocked) {
            }
            preNode = null;
            LOCAL.set(node);
        }
    }

    public void unlock() {
        CLHNode node = LOCAL.get();
        if (!UPDATER.compareAndSet(this, node, null)) {
            node.isLocked = false;
        }
        node = null;
    }
}
