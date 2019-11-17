package com.snow.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-11-02 15:35
 */
public class ThreadPoolExecutorDemo {

  public static void main(String[] args) {
    ThreadPoolExecutorDemo threadPoolExecutorDemo = new ThreadPoolExecutorDemo();
    threadPoolExecutorDemo.test();
  }

  public void test() {
    for (int i = 0; i < 1; i++) {
      Runnable runnable = () -> {
        System.out.println(Thread.currentThread().getName() + " >>>> Start");
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " >>>> End");
      };
//      executor.submit(runnable);
      executor.schedule(runnable, 60, TimeUnit.SECONDS);
      executor.schedule(runnable, 5, TimeUnit.SECONDS);
    }
  }

//  private ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 30, TimeUnit.SECONDS,
//    new ArrayBlockingQueue<>(10), new DefaultThreadFactory("group1"), new ThreadPoolExecutor.CallerRunsPolicy());

  private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

  class DefaultThreadFactory implements ThreadFactory {

    private ThreadGroup group = null;
    private AtomicInteger count = new AtomicInteger(0);

    DefaultThreadFactory(String name) {
      group = new ThreadGroup(name);
    }

    @Override
    public Thread newThread(Runnable r) {
      Thread thread = new Thread(group, r);
      thread.setName(group.getName()+"-"+count.getAndIncrement());
      return thread;
    }
  }
}


