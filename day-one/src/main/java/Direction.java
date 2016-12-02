public enum Direction {
  LEFT("L"),
  RIGHT("R");

  private final String shortCode;

  Direction(String shortCode) {
    this.shortCode = shortCode;
  }

  public static Direction byShortCode(String shortCode) {
    for (Direction current : values()) {
      if (current.shortCode.equals(shortCode)) {
        return current;

      }
    }
    throw new IllegalArgumentException(String.format("Could not instantiate Direction from %s", shortCode));
  }
}
