package io.tripled.adventofcode.dayfive;

class SpecialHashCodeWithPositionGenerator extends SpecialHashCodeGenerator {

  SpecialHashCodeWithPositionGenerator(String doorId) {
    super(doorId);
  }

  @Override
  protected boolean matchesPattern(String hash) {
    return hash.startsWith("00000") && hash.charAt(5) <= '7' && hash.charAt(5) > 0;
  }
}
