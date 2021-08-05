package com.thread.worker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkerA extends Thread {

  private boolean yieldThread;
  
  public WorkerA(boolean yieldThread) {
    this.yieldThread = yieldThread;
  }

  @Override
  public void run() {
    int counter = 0;
    if(yieldThread) {
      Thread.yield();
      System.out.println(Thread.currentThread().getName() + " yields");
    }
    while (++counter < 10) {
      System.out.println(Thread.currentThread().getName() + " counter:" + counter + " at:"
          + new SimpleDateFormat("HH:mm:ss SSS").format(new Date()));
    }
  }
}
