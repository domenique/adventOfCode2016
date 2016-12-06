package io.tripled.adventofcode.daythree;

import java.util.Objects;

class CandidateTriangle {
  private final int sideA;
  private final int sideB;
  private final int sideC;

  CandidateTriangle(int sideA, int sideB, int sideC) {
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
  }

  boolean isValid() {
    return sideA + sideB > sideC &&
        sideB + sideC > sideA &&
        sideA + sideC > sideB;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CandidateTriangle that = (CandidateTriangle) o;
    return sideA == that.sideA &&
        sideB == that.sideB &&
        sideC == that.sideC;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sideA, sideB, sideC);
  }

  @Override
  public String toString() {
    return "CandidateTriangle{" +
        "sideA=" + sideA +
        ", sideB=" + sideB +
        ", sideC=" + sideC +
        '}';
  }
}
