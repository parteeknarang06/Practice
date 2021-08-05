package com.java.threads.executor;

public class WorkerC implements Runnable{

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " starts");
    long index=0;
    for (long i = 0; i < 10000000; i++) {
      System.out.println("i="+i);
      if (Thread.currentThread().isInterrupted()) {
          System.out.println("Exiting gracefully");
      }
    }
  }


  
  
}
