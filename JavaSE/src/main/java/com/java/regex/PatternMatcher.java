package com.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

  public static void main(String[] args) {
    String input1="RUNNING-DATA_QUERYED";
    Pattern pattern = Pattern.compile("(RUNNING)-(UNKNOWN|QUERYING_DATA|DATA_QUERYED|PROCESSING_DATA|DATA_PROCESSED)");
    Matcher matcher = pattern.matcher(input1);
    if (matcher.find()) {
      System.out.println("pattern find");
    }
    if (matcher.matches()) {
      System.out.println("pattern matches");
      System.out.println(matcher.group(1));
    }
  }

}
