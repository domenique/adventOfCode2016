package io.tripled.adventofcode.dayseven;

import java.util.ArrayList;
import java.util.List;

class IPv7Address {

  List<IPv7Label> labels = new ArrayList<>();

  IPv7Address(String input) {
    String[] splitted = input.split("[\\[|\\]]");
    for (int i = 0; i < splitted.length; i++) {
      labels.add(new IPv7Label(splitted[i], i % 2 == 0));
    }
  }

  boolean isValid() {
    return true;
  }

  List<IPv7Label> getLabels() {
    return labels;
  }
}
