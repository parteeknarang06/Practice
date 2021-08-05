package com.concept.inheritence;

import com.concept.inheritence.workers.Calculate;
import com.concept.inheritence.workers.ClassA;
import com.concept.inheritence.workers.ClassB;
import com.concept.inheritence.workers.Mobile;

public class Inheritence {

  public static void main(String[] args) {
    ClassA objA = new ClassB();
    objA.m1();
    
    ClassA objB = new ClassB();
    ((ClassA) objB).m1();
    
    Calculate cal = new Mobile();
    System.out.println();
    cal.add();
    
    System.out.println();
    cal.substract();
    
    System.out.println();
    cal.additiveMultiply();
    
    System.out.println();
    cal.additiveDivide();
    
    System.out.println();
    cal.divide();
    
    System.out.println();
    cal.equals();
    
    //ClassB objB = new ClassA();
    m1(objA);
    m1(objB);
    m2(1.4f);
  }

  private static void m1(ClassA obj) {
    System.out.println("ClassA obj");
  }
  
  private static String m1(ClassB obj) {
    System.out.println("classb obj");
    return null;
  }
  
  private static void m2(double arg) {
    System.out.println("in m2");
  }
  
  private static void m3(float arg) {
    System.out.println("in m3");
  }
  
}


