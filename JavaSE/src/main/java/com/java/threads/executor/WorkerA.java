package com.java.threads.executor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkerA implements Runnable{
  private static Logger logger = LogManager.getLogger(WorkerA.class);
  private int count;
  private boolean printInterrupt;
  
  public WorkerA(int count) {
    this.count = count;
    this.printInterrupt = true;
  }
  
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " start:" + count);
    for (int i=0;i<=300000;i++) {
      if (Thread.currentThread().isInterrupted() && printInterrupt) {
        printInterrupt = false;
        System.out.println(Thread.currentThread().getName() + " Interrupted with count:" + count);
      }
      logger.info(Thread.currentThread().getName()+" with count:"+count+" index:"+i);
    }
    System.out.println(Thread.currentThread().getName() + " ends:" + count);
  }

  @Override
  public String toString() {
    return "Worker [count=" + count + "]";
  }
  
  
}
