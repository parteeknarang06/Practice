package com.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

  public static void main(String[] args) {
    BinaryOperator<Integer> op = BinaryOperator.maxBy((a, b) -> a > b ? 1 : a == b ? 0 : -1);
    System.out.println(op.apply(98, 100));
    op = BinaryOperator.minBy((a, b) -> a > b ? 1 : a == b ? 0 : -1);
    op = BinaryOperator.minBy((a, b) -> a > b ? 1 : a == b ? 0 : -1);
    List<TargetTable> collect = Stream.of(getTargetTableList1(), getTargetTableList2()).flatMap(getFunction()).collect(Collectors.toList());
    
    Optional<TargetTable> min = collect.stream().min((a, b) -> a.getProjectId().compareTo(b.getProjectId()));
    if (min.isPresent()) {
      System.out.println("collect min:" + min.get());
    }

  }
  
  private static Function<List<TargetTable>, Stream<TargetTable>> getFunction() {
    Function<List<TargetTable>, Stream<TargetTable>> function = new Function<List<TargetTable>, Stream<TargetTable>>() {
      @Override
      public Stream<TargetTable> apply(List<TargetTable> source) {
        return source.stream();
      }
    };
    return function;
  }
  
  private static List<TargetTable> getTargetTableList1() {
    List<TargetTable> objs = new ArrayList<TargetTable>();
    TargetTable obj = new TargetTable("p1", "d1", "t1");
    objs.add(obj);
    TargetTable obj1 = new TargetTable("p2", "d1", "t2");
    objs.add(obj1);
    return objs;
  }
  
  private static List<TargetTable> getTargetTableList2() {
    List<TargetTable> objs = new ArrayList<TargetTable>();
    TargetTable obj = new TargetTable("p3", "d1", "t1");
    objs.add(obj);
    TargetTable obj1 = new TargetTable("p4", "d1", "t2");
    objs.add(obj1);
    return objs;
  }
  
}
