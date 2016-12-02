package io.tripled.adventofcode.dayone;

enum Heading {
  NORTH,
  EAST,
  SOUTH,
  WEST;

  public Heading headLeft() {
    switch (this) {
      case NORTH:
        return Heading.WEST;
      case EAST:
        return Heading.NORTH;
      case SOUTH:
        return Heading.EAST;
      case WEST:
        return Heading.SOUTH;
      default:
        throw new IllegalArgumentException("Never Possible");
    }
  }

  public Heading headRight() {
    switch (this) {
      case NORTH:
        return Heading.EAST;
      case EAST:
        return Heading.SOUTH;
      case SOUTH:
        return Heading.WEST;
      case WEST:
        return Heading.NORTH;
      default:
        throw new IllegalArgumentException("Never Possible");
    }
  }
}
