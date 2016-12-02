package io.tripled.adventofcode.dayone;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position {

  private int x;
  private int y;
  private Heading heading;

  static Position of(int x, int y, Heading heading) {
    return new Position(x, y, heading);
  }

  private Position(int x, int y, Heading heading) {
    this.x = x;
    this.y = y;
    this.heading = heading;
  }

  List<Position> move(Movement movement) {
    switch (movement.getDirection()) {
      case LEFT:
        return headLeft(movement.getSteps());
      case RIGHT:
        return headRight(movement.getSteps());
      default:
        throw new IllegalArgumentException("Unknown direction provided.");
    }
  }

  private List<Position> headLeft(int steps) {
    Heading newHeading = heading.headLeft();
    return makeSteps(steps, newHeading);
  }

  private List<Position> headRight(int steps) {
    Heading newHeading = heading.headRight();
    return makeSteps(steps, newHeading);
  }

  private List<Position> makeSteps(int steps, Heading newHeading) {
    List<Position> visitedPositions = new ArrayList<>();
    switch (newHeading) {
      case NORTH:
        for (int i = 1; i <= steps; i++) {
          visitedPositions.add(new Position(x, y + i, newHeading));
        }
        break;
      case EAST:
        for (int i = 1; i <= steps; i++) {
          visitedPositions.add(new Position(x + i, y, newHeading));
        }
        break;
      case SOUTH:
        for (int i = 1; i <= steps; i++) {
          visitedPositions.add(new Position(x, y - i, newHeading));
        }
        break;
      case WEST:
        for (int i = 1; i <= steps; i++) {
          visitedPositions.add(new Position(x - i, y, newHeading));
        }
        break;
      default:
        throw new IllegalArgumentException("unknown direction");
    }
    return visitedPositions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return x == position.x &&
           y == position.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "Position{" +
           "x=" + x +
           ", y=" + y +
           ", heading=" + heading +
           '}';
  }

  public int distanceFromStart() {
    return Math.abs(x) + Math.abs(y);
  }
}
