package io.tripled.adventofcode.daytwo;

import java.util.Objects;

class Digit {

  private final char value;
  private int y;
  private int x;

  Digit(char value, int x, int y) {
    this.value = value;
    this.x = x;
    this.y = y;
  }

  Digit(char value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Digit digit = (Digit) o;
    return value == digit.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Digit{" +
        "value=" + value +
        '}';
  }

  int getY() {
    return y;
  }

  int getX() {
    return x;
  }
}
