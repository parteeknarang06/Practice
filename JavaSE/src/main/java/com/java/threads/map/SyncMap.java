package com.java.threads.map;

public class SyncMap {
  
  public static void main(String[] args) throws InterruptedException {
    ThreadManager.getInstance().createThreadGroup(getTaskId(), 20);
    System.out.println(" ");
    Thread t1 = new Thread(new WorkerB(getTaskId()));
    Thread t2 = new Thread(new WorkerA(getTaskId()));
    t1.setName("WorkerB");
    t2.setName("WorkerA");
    t1.setPriority(Thread.MAX_PRIORITY);
    t2.setPriority(Thread.MIN_PRIORITY);
    t1.start();
    //t1.start();
    Thread.sleep(2*1000);
    t2.start();
  }
  
  private static TaskId getTaskId() {
    return new TaskId("testName", 11, "2a");
  }
  
}

