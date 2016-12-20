package io.tripled.adventofcode.dayseven;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, InterruptedException {
    int count;
    try (TlsEnabledAddressCounter counter = new TlsEnabledAddressCounter("input.txt")) {
      count = counter.count();
    }
    System.out.println("Number of Tls Supported addresses: " + count);
    //    System.out.println("Line 1 (first variant)");
    //    Thread.sleep(500);
    //    System.out.print("\33[1A\33[2K");
    //    System.out.println("Line 1 (second variant)");
  }

}
