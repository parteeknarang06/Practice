package com.concept.inheritence.workers;

public class Mobile extends Calculator {

  @Override
  public void add() {
    System.out.println("Mobile add");
    super.add();
  }
  
  @Override
  public void substract() {
    System.out.println("Mobile substract");
    super.substract();
  }
  
  @Override
  public void multiply() {
    System.out.println("Mobile multiply");
  }
  
  @Override
  public void additiveMultiply() {
    System.out.println("Mobile additiveMultiply");
    super.additiveMultiply();
  }
  
  @Override
  public void additiveDivide() {
    System.out.println("Mobile additiveDivide");
    super.additiveDivide();
  }
}
