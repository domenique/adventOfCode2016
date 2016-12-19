package io.tripled.adventofcode.dayseven;

import java.util.ArrayList;
import java.util.List;

class IPv7Address {

  List<IPv7Label> labels = new ArrayList<>();

  IPv7Address(String input) {
    String[] splitted = input.split("[\\[|\\]]");
    for (int i = 0; i < splitted.length; i++) {
      labels.add(new IPv7Label(splitted[i], i % 2 != 0));
    }
  }

  boolean supportsTls() {
    boolean foundAbba = false;
    boolean foundAbbaInHyperNetLabel = false;
    for (IPv7Label label : labels) {
      if (label.isHyperNet() && label.containsAbba()) {
        foundAbbaInHyperNetLabel = true;
      }
      if (!label.isHyperNet() && label.containsAbba()) {
        foundAbba = true;
      }
    }
    return foundAbba && !foundAbbaInHyperNetLabel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    IPv7Address that = (IPv7Address) o;

    return labels != null ? labels.equals(that.labels) : that.labels == null;
  }

  @Override
  public int hashCode() {
    return labels != null ? labels.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "IPv7Address{" +
           "labels=" + labels +
           '}';
  }
}
