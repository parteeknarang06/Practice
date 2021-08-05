package com.java.interfaces;

public class Car implements Alarm, Vehicle {

  @Override
  public String turnAlarmOff() {
    return Alarm.super.turnAlarmOff();
  }

  @Override
  public String turnAlarmOn() {
    return Vehicle.super.turnAlarmOn();
  }
  
  @Override
  public void beep() {
    System.out.println("car beeping");
  }

}
