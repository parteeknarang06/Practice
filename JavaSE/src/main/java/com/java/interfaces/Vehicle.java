package com.java.interfaces;

public interface Vehicle {
  
  void beep();
  
  default String turnAlarmOn() {
    return "Vehicle: Turnng the alarm on";
  }
  
  default String turnAlarmOff() {
    return "Vehicle: Turnng the alarm off";
  }
}
