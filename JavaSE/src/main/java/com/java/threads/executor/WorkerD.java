package com.java.threads.executor;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkerD extends AbstractionWorkerD {

  private static Logger logger = LogManager.getLogger(WorkerD.class);
  private final int index;
  private boolean printInterruption;

  WorkerD() {
    this.index = 0;
  }

  WorkerD(int index) {
    this.printInterruption = true;
    this.index = index;
  }

  @Override
  public String toString() {
    return "WorkerD:[index]:" + index;
  }

  @Override
  public void start() throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " start starts, index:" + index + " at date:" + new Date());

    for (long i = 0; i <= 100000000; i++) {
      logger.info(Thread.currentThread().getName() + " index:" + i);
      checkStopTaskRequest();
    }
    System.out.println(Thread.currentThread().getName() + " start ends,   index:" + index + " at date:" + new Date());
  }
  
  private void checkStopTaskRequest() {
    if (Thread.currentThread().isInterrupted() && printInterruption) {
      printInterruption = false;
      System.out.println(
          Thread.currentThread().getName() + " index: " + index + " Exiting gracefully" + " at date:" + new Date());
       
    }
  }

  @Override
  public void getResult() throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " getResult starts, index:" + index + " at date:" + new Date());

    for (long i = 0; i <= 100000000; i++) {
      logger.info(Thread.currentThread().getName() + " index:" + i);
      checkStopTaskRequest();
    }
    System.out.println(Thread.currentThread().getName() + " getResult ends,   index:" + index + " at date:" + new Date());
  }
}
