package com.thread.worker;

import com.thread.common.CommonUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TargetB implements Runnable {
  
  @Override
  public void run() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    System.out.println(Thread.currentThread().getName() + " has started at:" + simpleDateFormat.format(new Date()));
    try {
      Thread.sleep(20 * 1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " has ended at:" + simpleDateFormat.format(new Date()));
    synchronized (CommonUtil.getLock()) {
      CommonUtil.getLock().notifyAll();
      System.out.println(Thread.currentThread().getName() + " has notifyAll at:" + simpleDateFormat.format(new Date()));
    }
  }
}
