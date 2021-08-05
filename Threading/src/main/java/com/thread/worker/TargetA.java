package com.thread.worker;

import com.thread.common.CommonUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TargetA extends Thread {

  
  @Override
  public void run() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    try {
      synchronized (CommonUtil.getLock()) {
        CommonUtil.getLock().wait();
      }
    } catch (InterruptedException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " has started at:" + simpleDateFormat.format(new Date()));
    try {
      Thread.sleep(20 * 1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " has ended at:" + simpleDateFormat.format(new Date()));
  }

}
