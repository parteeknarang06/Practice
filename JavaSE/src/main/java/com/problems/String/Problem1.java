package com.problems.String;

import java.util.List;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Problem1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your input strings:");
    String strInput1 = scanner.next();
    String strInput2 = scanner.next();
    System.out.println("Are inputs CaseSentitive:");
    boolean isCaseSentitive = scanner.nextBoolean();
    scanner.close();

    System.out.print("Output1:");
    print(strInput1, strInput2, isCaseSentitive);
    System.out.print("\nOutput2:");
    print(strInput2, strInput1, isCaseSentitive);

  }

  private static void print(String preferInput, String deferInput, boolean isCaseSentitive) {
    List<Character> charInput = preferInput.chars().mapToObj(getCharacter()).collect(Collectors.toList());
    charInput.stream()
        .filter(chars -> !isCaseSentitive ? deferInput.toLowerCase().indexOf(Character.toLowerCase(chars)) == -1
            : deferInput.indexOf(chars) == -1)
        .forEach(filteredChars -> {
          System.out.print(filteredChars);
        });
  }

  private static IntFunction<Character> getCharacter() {
    IntFunction<Character> characters = new IntFunction<Character>() {
      @Override
      public Character apply(int value) {
        return (char) value;
      }
    };
    return characters;
  }

}
