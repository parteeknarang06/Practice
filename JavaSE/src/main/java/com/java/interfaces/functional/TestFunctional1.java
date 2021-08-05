package com.java.interfaces.functional;

@FunctionalInterface
public interface TestFunctional1 {
  void test(String param);
  
  default void test1() {
    System.out.println("TestFunctional1 interface test1 default method");
  }
  
  static void test2() {
    System.out.println("TestFunctional1 interface test2 static method");
  }
}
