package com.java.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashMapDemo {

  public static void main(String[] args) {
    Map<String, Integer> hashMap = new HashMap<>(); 
    System.out.println("hashMap:");
    hashMap.put("c", 3);
    hashMap.put("a", 1);
    hashMap.put("d", 41);
    hashMap.put("e", 2);
    hashMap.put("p", 3);
    hashMap.put("m", 1);
    hashMap.put("o", 41);
    hashMap.put("z", 2);
    hashMap.put("b", 3);
    hashMap.put("f", 1);
    hashMap.put("q", 41);
    hashMap.put("v", 2);
    for (Entry<String, Integer> entry: hashMap.entrySet()) {
      System.out.println(entry);
    }
    
    System.out.println();
    System.out.println("linkedHashMap:");
    Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put("c", 3);
    linkedHashMap.put("a", 1);
    linkedHashMap.put("d", 41);
    linkedHashMap.put("e", 2);
    linkedHashMap.put("p", 3);
    linkedHashMap.put("m", 1);
    linkedHashMap.put("o", 41);
    linkedHashMap.put("z", 2);
    linkedHashMap.put("b", 3);
    linkedHashMap.put("f", 1);
    linkedHashMap.put("q", 41);
    linkedHashMap.put("v", 2);
    for (Entry<String, Integer> entry: linkedHashMap.entrySet()) {
      System.out.println(entry);
    }
    
    Set<Integer> hashSet = new HashSet<>();
    hashSet.add(3);
    hashSet.add(1);
    hashSet.add(5);
    hashSet.add(10);
    System.out.println();
    System.out.println("hashSet:");
    hashSet.stream().forEach(ele -> System.out.println(ele));
    
	Set<Integer> linkedHashSet = new LinkedHashSet<>();
	linkedHashSet.add(3);
	linkedHashSet.add(1);
	linkedHashSet.add(5);
	linkedHashSet.add(10);
	System.out.println();
	System.out.println("linkedHashSet:");
	Iterator<Integer> iterator = linkedHashSet.iterator();
	while(iterator.hasNext()) {
		Integer next = iterator.next();
	}
	
    
    Map<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("c", 3);
    treeMap.put("a", 1);
    treeMap.put("d", 41);
    treeMap.put("e", 2);
    treeMap.put("p", 3);
    treeMap.put("m", 1);
    treeMap.put("o", 41);
    treeMap.put("z", 2);
    treeMap.put("b", 3);
    treeMap.put("f", 1);
    treeMap.put("q", 41);
    treeMap.put("v", 2);
    System.out.println();
    System.out.println("treeMap:");
    for (Entry<String, Integer> entry: treeMap.entrySet()) {
      System.out.println(entry);
    }
    Set<Integer> treeSet = new TreeSet<>();
    
    
    
    
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> list1 = new LinkedList<Integer>();
  }

}
