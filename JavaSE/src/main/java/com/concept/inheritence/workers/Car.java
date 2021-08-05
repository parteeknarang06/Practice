package com.concept.inheritence.workers;

public class Car extends Vehicle {

//  @Override
//  public void trunAlarmOn() {
//    System.out.println("car alarm on");
//    
//  }

  @Override
  public void trunAlarmOff() {
    System.out.println("car alarm off");
  }
  
  @Override
  protected void test1() {
    super.test1();
  }

  @Override
  public void automaticAlarmOn() {
    super.automaticAlarmOn();
  }

}
