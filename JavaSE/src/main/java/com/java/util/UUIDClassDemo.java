package com.java.util;

import java.util.UUID;

public class UUIDClassDemo {
  
  public static void main(String[] args) {
    UUID obj = UUID.randomUUID();
    System.out.println(obj.toString());
    System.out.println(obj.variant());
  }
  
}
