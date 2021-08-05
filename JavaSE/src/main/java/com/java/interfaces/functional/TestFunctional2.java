package com.java.interfaces.functional;

@FunctionalInterface
public interface TestFunctional2 {
  void test();
  
  default void test1() {
    System.out.println("TestFunctional2 interface test1 default method");
  }
  
  public static void test2() {
    System.out.println("TestFunctional2 interface test2 public static method");
  }
}
