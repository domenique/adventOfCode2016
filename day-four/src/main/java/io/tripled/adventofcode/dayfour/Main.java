package io.tripled.adventofcode.dayfour;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) {
    InputStream stream = ClassLoader.getSystemResourceAsStream("input.txt");
    if (stream != null) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

      Integer sumOfCorrectRooms = reader.lines()
          .map(SecurityCode::of)
          .filter(SecurityCode::isValidChecksum)
          .peek(code -> System.out.println(code.getSectorId() + " : " + code.decrypt()))
          .map(SecurityCode::getSectorId)
          .mapToInt(Integer::intValue).sum();
      System.out.println("Sum of real rooms: " + sumOfCorrectRooms);
    }
  }
}
