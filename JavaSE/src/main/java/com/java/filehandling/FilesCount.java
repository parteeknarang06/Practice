package com.java.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class FilesCount {

  public static void main(String[] args) {
    File file = new File("/home/dataguise/Documents/SVN/trunk/DgWalker/libs");
    File[] files = file.listFiles();
    Stream.of(files).forEach(element -> {
      try {
        System.out.println(element.getCanonicalPath());
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });

  }

}
