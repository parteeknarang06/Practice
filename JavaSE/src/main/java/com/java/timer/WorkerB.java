package com.java.timer;

import java.util.Date;
import java.util.TimerTask;

public class WorkerB extends TimerTask {

  private boolean intialDelay;

  WorkerB(boolean intialDelay) {
    this.intialDelay = intialDelay;

  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " start at:" + new Date());
    if (intialDelay) {
      try {
        intialDelay = false;
        Thread.sleep(20 * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    for (int i = 1; i <= 5; i++) {

      System.out.print(i + " ");
    }
    System.out.println("\n" + Thread.currentThread().getName() + " end at:" + new Date() + "\n");

  }

}
