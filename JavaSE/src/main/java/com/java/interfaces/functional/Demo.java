package com.java.interfaces.functional;

public class Demo {
  public static void main(String[] args) {
    TestFunctional1 obj = new TestFunctional1() {

      @Override
      public void test(String param) {
        System.out.println("test successful with param:"+param);
        
      }
      
    };
    obj.test("check1");
    
    call1((element) -> System.out.println(element), "check2");
    
    call2(() -> System.out.println("This is self test of TestFunctional2"));
  }
  
  private static void call1(TestFunctional1 obj, String param) {
    obj.test(param);
  }
  
  private static void call2(TestFunctional2 obj) {
    obj.test();
  }
  
  static void test1() {
   System.out.println("Demo class test1 method"); 
  }
}
