package com.thread.methods;

import com.thread.worker.WorkerA;

import java.text.SimpleDateFormat;
import java.util.Date;

public class YieldDemo {

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new WorkerA(true));
    Thread t2 = new Thread(new WorkerA(false));
    t1.setName("th1");
    t2.setName("th2");
    t1.start();
    t2.start();
    //t1.join();
    //t2.join();
    //Thread.sleep(100);
    int counter = 0;
    while (++counter < 10) {
      System.out.println(Thread.currentThread().getName() + " counter:" + counter + " at:"
          + new SimpleDateFormat("HH:mm:ss SSS").format(new Date()));
    }
  }

}
