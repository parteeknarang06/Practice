package com.java.reflection;

public class SingletonClass {

  private static SingletonClass singletonClass;

  private SingletonClass() {
    // Make SingletonClass
  }

  public synchronized SingletonClass getInstance() {
    if (singletonClass == null) {
      singletonClass = new SingletonClass();
    }
    return singletonClass;
  }

}
