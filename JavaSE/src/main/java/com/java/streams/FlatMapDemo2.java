package com.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo2 {

  public static void main(String[] args) {
    List<TargetTable> tables1 = getTargetTableList1();
    List<TargetTable> tables2 = getTargetTableList2();
    
    Map<String, Integer> collect = Stream.of(tables1, tables2).flatMap(getFunction())
        .collect(Collectors.groupingBy(getGroupByFunction(), Collectors.summingInt(getSummingIntFunction())));
    System.out.println(collect);
    TreeMap<String, Integer> collect2 = Stream.of(tables1, tables2).flatMap(getFunction())
        .collect(Collectors.groupingBy(getGroupByFunction(), TreeMap::new, Collectors.summingInt(getSummingIntFunction())));
    System.out.println(collect2);
  }
  
  private static ToIntFunction<TargetTable> getSummingIntFunction() {
    ToIntFunction<TargetTable> fun = new ToIntFunction<TargetTable>() {
      @Override
      public int applyAsInt(TargetTable value) {
        return value.getListCols().size();
      }
    };
    return fun;
  }
  
  private static Function<TargetTable, String> getGroupByFunction() {
    Function<TargetTable, String> fun = new Function<TargetTable, String>() {
      @Override
      public String apply(TargetTable source) {
        return source.getProjectId();
      }
    };
    return fun;
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
  
  private static List<TargetTable> getTargetTableList1() {
    List<TargetTable> objs = new ArrayList<TargetTable>();
    TargetTable obj = new TargetTable("p1", "d1", "t1");
    obj.setListCols(new ArrayList<TargetColumns>() {
      private static final long serialVersionUID = 1L;
      {
        add(new TargetColumns("p1", "d1", "t1", "c1", "dt1"));
        add(new TargetColumns("p1", "d1", "t1", "c2", "dt2"));
      }
    });
    TargetTable obj1 = new TargetTable("p1", "d1", "t2");
    obj1.setListCols(new ArrayList<TargetColumns>() {
      private static final long serialVersionUID = 1L;
      {
        add(new TargetColumns("p1", "d1", "t2", "c1", "dt1"));
        add(new TargetColumns("p1", "d1", "t2", "c2", "dt2"));
        add(new TargetColumns("p1", "d1", "t2", "c3", "dt1"));
      }
    });
    
    objs.add(obj);
    objs.add(obj1);
    return objs;
  }
  
  private static List<TargetTable> getTargetTableList2() {
    List<TargetTable> objs = new ArrayList<TargetTable>();
    TargetTable obj = new TargetTable("p2", "d1", "t1");
    obj.setListCols(new ArrayList<TargetColumns>() {
      private static final long serialVersionUID = 1L;
      {
        add(new TargetColumns("p2", "d1", "t1", "c1", "dt1"));
        add(new TargetColumns("p2", "d1", "t1", "c3", "dt1"));
      }
    });
    TargetTable obj1 = new TargetTable("p2", "d1", "t2");
    obj1.setListCols(new ArrayList<TargetColumns>() {
      private static final long serialVersionUID = 1L;
      {
        add(new TargetColumns("p2", "d1", "t2", "c1", "dt1"));
      }
    });
    
    objs.add(obj);
    objs.add(obj1);
    return objs;
  }
}
