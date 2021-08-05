package com.concept.inheritence.workers;

public abstract class Calculator extends Compute {

  @Override
  public void substract() {
    System.out.println("Calculator substract");
  }

  @Override
  public void multiply() {
    System.out.println("Calculator multiply");
  }

  @Override
  public void divide() {
    System.out.println("Calculator divide");
  }
  
}
