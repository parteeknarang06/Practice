package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ConversionPrimToNonPrim {

  public static void main(String[] args) {
    String str="ABC";
    str.chars().mapToObj((ch)-> ch);
    //collect1.forEach(c-> System.out.println(c));
    
    List<Character> collect = str.chars().mapToObj(getIntFun()).collect(Collectors.toList());
    collect.forEach(c-> System.out.println(c));
    
    int[] ar1 = { 1, 2, 3, 4, 5 };
    List<Integer> collect2 = IntStream.of(ar1).boxed().collect(Collectors.toList());
    collect2.forEach(e -> System.out.print(e));
    
    List<Integer> collect3 = Arrays.stream(ar1).boxed().collect(Collectors.toList());
    collect3.forEach(e -> System.out.print(e));
    
    m1(new ArrayList<Character>());
  }
  
  private static IntFunction<Character> getIntFun() {
    IntFunction<Character> func = new IntFunction<Character>() {
      @Override
      public Character apply(int value) {
        // TODO Auto-generated method stub
        return Character.valueOf((char)value);
      }
    };
    return func;
  }
  
  private static <U> void m1(List<? extends U> list) {
    
  }
}
