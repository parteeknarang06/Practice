package com.locking;

public class ClassLevelLocking {

  public static void main(String[] args) {
    TargetA targetA = new TargetA();
    
    Thread t1 = new Thread() {
      @Override
      public void run() {
        try {
          TargetA.run5();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    };
    
    Thread t2 = new Thread() {
      @Override
      public void run() {
        try {
          targetA.run4();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    };
    
    t1.setName("thread1");
    t2.setName("thread2");
    
    t1.start(); t2.start();
  }

}
