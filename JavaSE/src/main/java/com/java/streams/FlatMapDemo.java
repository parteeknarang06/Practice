package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {

  public static void main(String[] args) {
    List<Object[]> objs = getObjectList();
    List<TargetTable> tables = getTargetTableList1();
    List<TargetColumns> columns = getTargetColumnList1();
    Stream<List<? extends Object>> tabColStream = Stream.of(columns,tables);
    List<Object> flatMap = tabColStream.flatMap(getFunction1()).collect(Collectors.toList());
    
    List<? super TargetTable> list = new ArrayList<TargetTable>(); 
    list.add(new TargetTable("p1", "d1", "t1"));
    
    
    /* flat map with same collection*/
    List<TargetTable> tables1 = getTargetTableList1();
    List<TargetTable> tables2 = getTargetTableList2();
    System.out.println("tables1: "+tables1.size());
    tables1.forEach(element -> {
      System.out.println(element);
    });
    System.out.println("tables2: "+tables2.size());
    tables2.forEach(element -> {
      System.out.println(element);
    });
    
    /* Stream.of(..) and Arrays.asList.stream() both give same output*/
    System.out.println();
    Stream<List<TargetTable>> combinedStream = Stream.of(tables2, tables1);
    //List<TargetTable> collect = combinedStream.flatMap(s->s.stream()).collect(Collectors.toList());
    List<TargetTable> collect = combinedStream.flatMap(getFunction()).collect(Collectors.toList());
    
    System.out.println("collect:"+collect.size());
    collect.forEach(element -> {
      System.out.println(element);
    });
    
    System.out.println();
    List<List<TargetTable>> asList = Arrays.asList(tables1, tables2);
    Stream<List<TargetTable>> stream = asList.stream();
    collect = stream.flatMap(Collection::stream).collect(Collectors.toList());
    
    System.out.println("collect:"+collect.size());
    collect.forEach(element -> {
      System.out.println(element);
    });
    
  }

  private static Function<List<TargetTable>, Stream<TargetTable>> getFunction() {
    Function<List<TargetTable>, Stream<TargetTable>> fun = new Function<List<TargetTable>, Stream<TargetTable>>() {
      @Override
      public Stream<TargetTable> apply(List<TargetTable> source) {
        return source.stream();
      }
    };
    return fun;
  }
  
  private static Function<List<? extends Object>, Stream<? extends Object>> getFunction1() {
    Function<List<? extends Object>, Stream<? extends Object>> fun = new Function<List<? extends Object>, Stream<? extends Object>>() {
      @Override
      public Stream<? extends Object> apply(List<? extends Object> t) {
        return t.stream();
      }
    };
    return fun;
  }
  
  private static Function<List<? extends Object>, List<TargetTable>> getFunction2() {
    Function<List<? extends Object>, List<TargetTable>> fun = new Function<List<? extends Object>, List<TargetTable>>() {
      @Override
      public List<TargetTable> apply(List<? extends Object> source) {
        List<TargetTable> ar = new ArrayList<>();
        source.forEach(element -> {
          Class<List> listCast = List.class;
          List list = listCast.cast(element);
          
        });
        return ar;
      }
    };
    return fun;
  }
  
  private static List<Object[]> getObjectList() {
    List<Object[]> objs = new ArrayList<Object[]>();
    Object[] obj1 = {"p1", "d1", "t1", "c1"};
    objs.add(obj1);
    Object[] obj2 = {"p1", "d1", "t1", "c2"};
    objs.add(obj2);
    Object[] obj3 = {"p1", "d1", "t2", "c1"};
    objs.add(obj3);
    Object[] obj4 = {"p1", "d1", "t2", "c1"};
    objs.add(obj4);
    return objs;
  }
  
  private static List<TargetTable> getTargetTableList1() {
    List<TargetTable> objs = new ArrayList<TargetTable>();
    TargetTable obj = new TargetTable("p1", "d1", "t1");
    objs.add(obj);
    TargetTable obj1 = new TargetTable("p1", "d1", "t2");
    objs.add(obj1);
    return objs;
  }
  
  private static List<TargetTable> getTargetTableList2() {
    List<TargetTable> objs = new ArrayList<TargetTable>();
    TargetTable obj = new TargetTable("p2", "d1", "t1");
    objs.add(obj);
    TargetTable obj1 = new TargetTable("p2", "d1", "t2");
    objs.add(obj1);
    return objs;
  }
  
  private static List<TargetColumns> getTargetColumnList1() {
    List<TargetColumns> objs = new ArrayList<TargetColumns>();
    TargetColumns obj1 = new TargetColumns("p1", "d1", "t1", "c1", "dt1");
    objs.add(obj1);
    TargetColumns obj2 = new TargetColumns("p1", "d1", "t2", "c1", "dt1");
    objs.add(obj2);
    return objs;
  }
}
