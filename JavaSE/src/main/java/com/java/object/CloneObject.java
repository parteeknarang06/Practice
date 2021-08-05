package com.java.object;

public class CloneObject {

  public static void main(String[] args) throws CloneNotSupportedException {
    ClassA obj1 = new ClassA("test");
    ClassA obj2;
    System.out.println("Initial:");
    System.out.println("obj1:" + obj1);
    System.out.println("obj1 hascode:" + obj1.hashCode());

    System.out.println("\nafter cloning:");
    obj2 = (ClassA) obj1.clone();
    System.out.println("obj1:" + obj1);
    System.out.println("obj1 hascode:" + obj1.hashCode());
    System.out.println("obj2:" + obj2);
    System.out.println("obj2 hascode:" + obj2.hashCode());

    System.out.println("\nafter cloning & modification:");
    obj2.setName("dsd");
    System.out.println("obj1:" + obj1);
    System.out.println("obj1 hascode:" + obj1.hashCode());
    System.out.println("obj2:" + obj2);
    System.out.println("obj2 hascode:" + obj2.hashCode());
    
    obj2 = obj1;
    System.out.println("\nafter assignment:");
    System.out.println("obj1:" + obj1);
    System.out.println("obj1 hascode:" + obj1.hashCode());
    System.out.println("obj2:" + obj2);
    System.out.println("obj2 hascode:" + obj2.hashCode());
    
    obj2.setName("a");
    System.out.println("\nafter modification:");
    System.out.println("obj1:" + obj1);
    System.out.println("obj1 hascode:" + obj1.hashCode());
    System.out.println("obj2:" + obj2);
    System.out.println("obj2 hascode:" + obj2.hashCode());
  }

}

class ClassA extends Object implements Cloneable {

  private String name;

  public ClassA(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
  }

  @Override
  public String toString() {
    return "ClassA [name=" + name + "]";
  }

}