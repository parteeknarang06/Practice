package com.thread.common;

public class CommonUtil {

  private static final Object lock;

  static {
    lock = new Object();
  }

  public static Object getLock() {
    return lock;
  }

}
