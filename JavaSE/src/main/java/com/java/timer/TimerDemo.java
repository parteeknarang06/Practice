package com.java.timer;

import java.util.Date;
import java.util.Timer;

public class TimerDemo {

  public static void main(String[] args) throws InterruptedException {
    WorkerA obj = new WorkerA();
    Timer timer = new Timer();
    timer.schedule(obj, 5 *1000, 15 *1000);
    System.out.println("Task scheduled at:" + new Date()+"\n");
    Thread.sleep(90 * 1000);
    timer.cancel();
    timer.purge();
    System.out.println("Task ended at:" + new Date()+"\n");
    
    System.out.println("Task rescheduled at:" + new Date()+"\n");
    timer.schedule(obj, 5 *1000, 15 *1000);
    
  }

}
