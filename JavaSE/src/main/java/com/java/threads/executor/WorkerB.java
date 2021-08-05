package com.java.threads.executor;

import java.util.concurrent.Callable;

public class WorkerB implements Callable<Double>{

  @Override
  public Double call() throws Exception {
    System.out.println(Thread.currentThread().getName() + " starts");
    long index=0;
    for (long i = 0; i < 10000000; i++) {
      System.out.println("i="+i);
      if (Thread.currentThread().isInterrupted()) {
          System.out.println("Exiting gracefully");
          
      }
    }
    return (double) index;
  }


  
  
}
