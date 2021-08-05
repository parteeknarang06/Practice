package com.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetConversion {

  public static void main(String[] args) {
    List<Integer> test = new ArrayList<Integer>();
    test.add(1);
    test.add(2);
    test.add(3);
    test.add(3);
    System.out.println("List:");
    test.stream().forEach(element -> System.out.print(element + " "));
    System.out.println("\n List with distinct:");
    test.stream().distinct().forEach(element -> System.out.print(element + " "));
    Set<Integer> testSet = test.stream().collect(Collectors.toSet());
    System.out.println("\nset:");
    testSet.stream().forEach(element -> System.out.print(element + " "));
  }

}
