package com.start.SpringBootPractice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class SpringBootPracticeApplicationTests {

  List<String> mockedList = mock(List.class);
  
	@Test
	void verifyMethod() {
	  String str1 = mockedList.get(0);
	  mockedList.get(2); 
	  verify(mockedList).get(2);
	  mockedList.get(2);
	  verify(mockedList, times(2)).get(2);
	  verify(mockedList, atLeast(2)).get(anyInt());
	}
	
	@Test
	void argumentCapturing() {
	  mockedList.add("valueAddedAt");
	  ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
	  verify(mockedList).add(arg.capture());
	  assertEquals("valueAddedAt", arg.getValue());
	}

	@Test
  void multipleArgumentCapturing() {
    mockedList.add("valueAddedAt1");
    mockedList.add("valueAddedAt2");
    
    ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
    verify(mockedList, times(2)).add(arg.capture());
    
    List<String> allVals = arg.getAllValues();
    String strCheck = allVals.get(0);
    assertEquals("valueAddedAt1", strCheck);
    
    strCheck = allVals.get(1);
    assertEquals("valueAddedAt2", strCheck);
  }
	
	@Test
	void mocking() {
	  ArrayList<String> mockedList = mock(ArrayList.class);
	  System.out.println("\nmocking:");
	  System.out.println(mockedList.size());
	  mockedList.add("first");
	  mockedList.add("2nd");
	  System.out.println(mockedList.size());
	  System.out.println(mockedList.get(0));
	  when(mockedList.size()).thenReturn(5);
	  System.out.println(mockedList.size());
	}
	
	@Test
  void spying() {
    ArrayList<String> mockedList = spy(ArrayList.class);
    System.out.println("\nspy:");
    System.out.println(mockedList.size());
    mockedList.add("first");
    mockedList.add("2nd");
    System.out.println(mockedList.size());
    System.out.println(mockedList.get(0));
    when(mockedList.size()).thenReturn(5);
    System.out.println(mockedList.size());
    mockedList.add("3rd");
    System.out.println(mockedList.size());
  }
	
}
