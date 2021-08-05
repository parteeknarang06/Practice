package com.java.string;

public class StringNullDemo {

  public static void main(String[] args) {
    String s1="fd";
    //String s2="fd";
    String s2=null;
    if (s1.equalsIgnoreCase(s2)) {
      System.out.println("match");
    } else {
      System.out.println("not match");
    }
  }

}
