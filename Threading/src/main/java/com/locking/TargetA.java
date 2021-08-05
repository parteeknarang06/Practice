package com.locking;

import java.util.Date;

public class TargetA {
  
  public void run1() throws InterruptedException {
    synchronized (TargetA.class) {
      System.out.println(Thread.currentThread().getName()+" is acquiring class level lock in method run1 at :"+new Date());
      Thread.sleep(10 *1000);
      System.out.println(Thread.currentThread().getName()+" is releasing class level lock in method run1 at :"+new Date());
    }
  }
  
  public void run2() throws InterruptedException {
    synchronized (TargetA.class) {
      System.out.println(Thread.currentThread().getName()+" is acquiring class level lock in method run2 at :"+new Date());
      Thread.sleep(10 *1000);
      System.out.println(Thread.currentThread().getName()+" is releasing class level lock in method run2 at :"+new Date());
    }
  }
  
  public synchronized void run3() throws InterruptedException {
      System.out.println(Thread.currentThread().getName()+" is acquiring class level lock in method run3 at :"+new Date());
      Thread.sleep(10 *1000);
      System.out.println(Thread.currentThread().getName()+" is releasing class level lock in method run3 at :"+new Date());
  }
  
  public synchronized void run4() throws InterruptedException {
      System.out.println(Thread.currentThread().getName()+" is acquiring class level lock in method run4 at :"+new Date());
      Thread.sleep(10 *1000);
      System.out.println(Thread.currentThread().getName()+" is releasing class level lock in method run4 at :"+new Date());
  }
  
  public static synchronized void run5() throws InterruptedException {
    System.out.println(Thread.currentThread().getName()+" is acquiring class level lock in method run5 at :"+new Date());
    Thread.sleep(10 *1000);
    System.out.println(Thread.currentThread().getName()+" is releasing class level lock in method run5 at :"+new Date());
  }

  public static synchronized void run6() throws InterruptedException {
    System.out.println(Thread.currentThread().getName()+" is acquiring class level lock in method run6 at :"+new Date());
    Thread.sleep(10 *1000);
    System.out.println(Thread.currentThread().getName()+" is releasing class level lock in method run6 at :"+new Date());
  }
  
}
