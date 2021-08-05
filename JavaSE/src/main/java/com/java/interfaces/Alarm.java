package com.java.interfaces;

public interface Alarm {
  
  void beep();
  
  default String turnAlarmOn() {
    return "Alarm: Turnng the alarm on";
  }
  
  default String turnAlarmOff() {
    return "Alarm: Turnng the alarm off";
  }
  
}
