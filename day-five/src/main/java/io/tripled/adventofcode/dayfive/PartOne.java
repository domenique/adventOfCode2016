package io.tripled.adventofcode.dayfive;

class PartOne {

  public static void main(String[] args) {
    SecurityDoorBruteForcer bruteForcer = new SecurityDoorBruteForcer("ffykfhsq");

    System.out.println(bruteForcer.bruteForce());
  }
}
