package com.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FIlterCheck1 {

  public static void main(String[] args) {
    List<TargetTable> tables = getTargetTableList();
    TargetTable table = tables.stream().filter(element->element.getProjectId().equalsIgnoreCase("p1")).findFirst().get();
    System.out.println(table);
    tables = tables.stream().filter(element->element.getProjectId().equalsIgnoreCase("p4")).collect(Collectors.toList());
    System.out.println(tables.size());
  }

  private static List<TargetTable> getTargetTableList() {
    List<TargetTable> objs = new ArrayList<TargetTable>();
    TargetTable obj = new TargetTable("p1", "d1", "t1");
    objs.add(obj);
    TargetTable obj1 = new TargetTable("p1", "d1", "t2");
    objs.add(obj1);
    return objs;
  }
}
