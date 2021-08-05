package com.java.string;

import java.util.ArrayList;
import java.util.List;

public class StringOperations {

  public static void main(String[] args) {
    List<String> strList = new ArrayList<String>();
    strList.add("a");
    strList.add("b");
    strList.add("c");
    System.out.println(String.join(",", strList));
    
    String str="d,e,f";
    String[] strArr= str.split(",");
    for (String e : strArr) {
      System.out.println(e);
    }
    
    str="  d,e, f  ";
    System.out.println(str.trim());
    
    
  }

}
