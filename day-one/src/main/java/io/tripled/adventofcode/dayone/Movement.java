package io.tripled.adventofcode.dayone;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movement {

  private static final Pattern PATTERN = Pattern.compile("([LR])([0-9]+)");

  private Direction direction;
  private int steps;

  static Movement parse(String pattern) {
    Matcher matcher = PATTERN.matcher(pattern);
    if (matcher.matches()) {
      return new Movement(Direction.byShortCode(matcher.group(1)), Integer.valueOf(matcher.group(2)));
    } else {
      throw new IllegalArgumentException(String.format("Could not instantiate a Movement from %s", pattern));
    }
  }

  Movement(Direction direction, int steps) {
    this.direction = direction;
    this.steps = steps;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Movement movement = (Movement) o;
    return steps == movement.steps &&
        direction == movement.direction;
  }

  @Override
  public int hashCode() {
    return Objects.hash(direction, steps);
  }

  public int getSteps() {
    return steps;
  }

  public Direction getDirection() {
    return direction;
  }
}
