package com.concept.inheritence.workers;

public abstract class Compute implements Calculate {

  @Override
  public void add() {
    System.out.println("Compute add");
  }

  @Override
  public void substract() {
    System.out.println("Compute substract");
  }

  @Override
  public void divide() {
    System.out.println("Compute divide");
  }

  @Override
  public void additiveMultiply() {
    System.out.println("Compute additiveMultiply");
    multiply();
  }

  @Override
  public void additiveDivide() {
    System.out.println("Compute additiveDivide");
    divide();
  }
  
  @Override
  public void equals() {
    System.out.println("Compute equals");
  }
}
