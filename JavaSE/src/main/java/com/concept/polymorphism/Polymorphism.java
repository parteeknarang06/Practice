package com.concept.polymorphism;

public class Polymorphism {

  public static void main(String[] args) {
    //print(null); /** ambiguous Polymorphism **/
  }

  private static void print(Object obj) {
    
  }
  
  private static void print(Integer str) {
    
  }

  private static String print(String str) {
    return str;
  }
  
}
