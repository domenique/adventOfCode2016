package io.tripled.adventofcode.dayfive;

class PartTwo {

  public static void main(String[] args) {
    SecurityDoorBruteForcerWithPosition bruteForcer = new SecurityDoorBruteForcerWithPosition("ffykfhsq");

    System.out.println(bruteForcer.bruteForce());
  }
}
