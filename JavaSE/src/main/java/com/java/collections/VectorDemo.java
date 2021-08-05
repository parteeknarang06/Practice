package com.java.collections;

import java.util.Vector;

public class VectorDemo {

  public static void main(String[] args) {
    A obj1 = new A("test");
    A obj2 = new A("test");
    System.out.println(obj1);
    System.out.println(obj2);
    System.out.println(obj1==obj2);
    System.out.println(obj1.equals(obj2));
  }

}

class A {
  private String name;

  public A(String name) {
    this.name = name;
  }
  
}