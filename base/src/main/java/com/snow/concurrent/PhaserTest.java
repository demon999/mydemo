package com.snow.concurrent;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 2019-06-30 16:41
 */
public class PhaserTest {

  public static void main(String[] args) throws InterruptedException {
    final Phaser phaser = new Phaser(3);
    for (int i = 0; i < 3; i++) {
      TimeUnit.SECONDS.sleep(1);
      Thread thread = new Thread(new MyPhaser(phaser));
      thread.start();
    }
  }


  static class MyPhaser implements Runnable {
    private Phaser phaser;

    public MyPhaser(Phaser phaser) {
      this.phaser = phaser;
    }

    @Override
    public void run() {
      System.out.printf("step>> %s >> %s >> %s \n", 0, phaser.getPhase(), Thread.currentThread().getName());
      phaser.arriveAndAwaitAdvance();
      System.out.printf("step>> %s >> %s >> %s \n", 1, phaser.getPhase(), Thread.currentThread().getName());
      phaser.arriveAndAwaitAdvance();
      System.out.printf("step>> %s >> %s >> %s \n", 2, phaser.getPhase(), Thread.currentThread().getName());
      phaser.arriveAndDeregister();
    }
  }

}
