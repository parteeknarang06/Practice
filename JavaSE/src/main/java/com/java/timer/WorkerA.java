package com.java.timer;

import java.util.Date;
import java.util.TimerTask;

public class WorkerA extends TimerTask {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " start at:" + new Date());
    for (int i=1; i<=5; i++) {
      System.out.print(i +" ");
    }
    System.out.println("\n"+Thread.currentThread().getName() + " end at:" + new Date()+"\n");
    
  }

}
