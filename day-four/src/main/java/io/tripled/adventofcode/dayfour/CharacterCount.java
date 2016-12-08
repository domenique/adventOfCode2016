package io.tripled.adventofcode.dayfour;

import java.util.Map;

class CharacterCount implements Comparable<CharacterCount> {

  private Character character;
  private long count;

  CharacterCount(Map.Entry<Character, Long> entry) {
    this.character = entry.getKey();
    this.count = entry.getValue();
  }

  Character getCharacter() {
    return character;
  }

  @Override
  public int compareTo(CharacterCount o) {
    int count = Long.compare(o.count, this.count);
    if (count == 0) {
      return character.compareTo(o.character);
    }
    return count;
  }

  @Override
  public String toString() {
    return "CharacterCount{" +
        "character=" + character +
        ", count=" + count +
        '}';
  }
}
