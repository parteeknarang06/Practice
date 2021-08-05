package com.thread.methods;

import com.thread.worker.TargetA;
import com.thread.worker.TargetB;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JoinDemo {

  public static void main(String[] args) throws InterruptedException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    System.out.println("Main method starts at:" + simpleDateFormat.format(new Date()));
    Thread t1 = new Thread(new TargetA());
    Thread t2 = new Thread(new TargetB());
    Thread t3 = new Thread(new TargetA());
    t1.setName("TargetA_1");
    t2.setName("TargetB");
    t3.setName("TargetA_2");
    
    t1.start();
    t2.start();
    t3.start();
    
    t1.join(3 * 1000);
    t2.join(3 * 1000);
    
    System.out.println("Main method ends at:" + simpleDateFormat.format(new Date()));
  }

}
