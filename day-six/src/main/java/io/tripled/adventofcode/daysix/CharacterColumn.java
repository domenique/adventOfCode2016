package io.tripled.adventofcode.daysix;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class CharacterColumn {

  Map<Character, Long> characterCount;

  CharacterColumn() {
    characterCount = new HashMap<>();
  }

  void addCharacter(char aChar) {
    characterCount.compute(aChar, (character, aLong) -> (aLong == null ? 0L : aLong) + 1);
  }

  String getHighestCountedChar() {
    Character curChar = ' ';
    Long count = 0L;
    for (Entry<Character, Long> current : characterCount.entrySet()) {
      if (count < current.getValue()) {
        curChar = current.getKey();
        count = current.getValue();
      }
    }

    return curChar.toString();
  }

  String getLowestCountedChar() {
    Character curChar = ' ';
    Long count = Long.MAX_VALUE;
    for (Entry<Character, Long> current : characterCount.entrySet()) {
      if (count > current.getValue()) {
        curChar = current.getKey();
        count = current.getValue();
      }
    }

    return curChar.toString();
  }
}
