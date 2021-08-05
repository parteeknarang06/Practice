package com.java.interfaces.functional;

public class MethodRef {

  public static void main(String[] args) {
    TestFunctional1 obj = (param)->System.out.println(param);
    obj.test("my");
    obj.test1();
  }

}
