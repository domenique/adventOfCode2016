package io.tripled.adventofcode.daythree;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    int triangles = 0;
    int validTriangles = 0;
    InputReader reader = new VerticalInputReader("input.txt");

    CandidateTriangle triangle = reader.read();
    while (triangle != null) {
      triangles++;
      System.out.println(String.format("Triangle (%s) : %s", triangles, triangle));
      if (triangle.isValid()) {
        validTriangles++;
      }

      triangle = reader.read();
    }
    reader.close();
    System.out.println("Valid triangles : " + validTriangles);
  }
}
