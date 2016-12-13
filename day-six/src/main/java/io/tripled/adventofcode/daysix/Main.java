package io.tripled.adventofcode.daysix;

import java.io.IOException;

class Main {

  public static void main(String[] args) {
    try (NoiseCanceller noiseCanceller = new NoiseCanceller("input.txt", 8)) {
      String decoded = noiseCanceller.decodeWithLowestCountedChars();
      System.out.println("Decoded String: " + decoded);

    } catch(IOException e) {
      e.printStackTrace();

    }
  }
}
