package com.java.test.interfaces;

import com.java.interfaces.functional.TestFunctional1;
import com.java.interfaces.functional.TestFunctional2;

public class FunctionalDemo {
  public static void main(String[] args) {
    TestFunctional2.test2();
    TestFunctional1.test2();
    
  }
}

class Alpha implements TestFunctional1{

  @Override
  public void test(String param) {
    
  }
  @Override
  public void test1() {
    
  }
}

class beta implements TestFunctional2{

  @Override
  public void test() {
    
  }
  @Override
  public void test1() {
    
  }
  
  
}
