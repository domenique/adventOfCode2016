package io.tripled.adventofcode.daytwo;

import java.util.Objects;

class Digit {

  private final int value;
  private int y;
  private int x;

  Digit(int value, int x, int y) {
    this.value = value;
    this.x = x;
    this.y = y;
  }

  Digit(int value) {
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

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }
}
