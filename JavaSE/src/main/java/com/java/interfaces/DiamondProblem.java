package com.java.interfaces;

public class DiamondProblem {

  public static void main(String[] args) {
    Alarm car = new Car();
    System.out.println(car.turnAlarmOff());
    System.out.println(car.turnAlarmOn());
    car.beep();
  }

}
