package io.tripled.adventofcode.dayseven;

class IPv7Label {

  private String input;
  private boolean hyperNet;

  IPv7Label(String input, boolean isHyperNetLabel) {
    this.input = input;
    this.hyperNet = isHyperNetLabel;
  }

  boolean isHyperNet() {
    return hyperNet;
  }

  boolean containsAbba() {
    for (int i = 0; i <= input.length() - 4; i++) {
      String firstPart = input.substring(i, i + 2);
      String secondPart = input.substring(i + 2, i + 4);
      if (isAbba(firstPart, secondPart)) {
        return true;
      }
    }
    return false;
  }

  private boolean isAbba(String firstPart, String secondPart) {
    return reverse(firstPart).equals(secondPart) && !firstPart.equals(secondPart);
  }

  private String reverse(String firstPart) {
    return new StringBuilder(firstPart).reverse().toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    IPv7Label iPv7Label = (IPv7Label) o;

    if (hyperNet != iPv7Label.hyperNet) {
      return false;
    }
    return input != null ? input.equals(iPv7Label.input) : iPv7Label.input == null;
  }

  @Override
  public int hashCode() {
    int result = input != null ? input.hashCode() : 0;
    result = 31 * result + (hyperNet ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "IPv7Label{" +
           "input='" + input + '\'' +
           ", hyperNet=" + hyperNet +
           '}';
  }
}
