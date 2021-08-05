package com.java.collections;

import java.util.Stack;

public class StackDemo {

  public static void main(String[] args) {
    Stack<Character> stack = new Stack<Character>();
    String str= "IamEngineer";
    
    char[] arr = str.toCharArray();
    for (char ch:arr) {
      stack.add(ch);
    }
    stack.forEach(element ->System.out.print(element));
    StringBuilder str1 = new StringBuilder();
    while (!stack.isEmpty()) {
      str1.append(stack.pop());
    }
    System.out.println("\n"+str1.toString());
    
  }

}
