package io.tripled.adventofcode.dayfive;

class Main {

  public static void main(String[] args) {
    SecurityDoorBruteForcer bruteForcer = new SecurityDoorBruteForcer("ffykfhsq");
    System.out.println("Part one: " + bruteForcer.bruteForce());

    SecurityDoorBruteForcerWithPosition bruteForcerWithPosition = new SecurityDoorBruteForcerWithPosition("ffykfhsq");
    System.out.println("Part two: " + bruteForcerWithPosition.bruteForce());
  }
}
