package com.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    // SingletonClass obj =new SingletonClass();

    Class<?> c = Class.forName("com.java.reflection.SingletonClass");
    Constructor<?> declaredConstructor = c.getDeclaredConstructor();
    declaredConstructor.setAccessible(true);
    SingletonClass newInstance = (SingletonClass) declaredConstructor.newInstance();
    System.out.println(newInstance);
  }

}
