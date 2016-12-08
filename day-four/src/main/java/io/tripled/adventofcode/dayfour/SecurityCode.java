package io.tripled.adventofcode.dayfour;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class SecurityCode {

  private static final Pattern PATTERN = Pattern.compile("([a-z|A-Z|\\-]*)-(\\d*)\\[(.*)\\]");
  private String encryptedName;
  private int sectorId;
  private String checksum;

  static SecurityCode of(String value) {
    Matcher matcher = PATTERN.matcher(value);
    if (matcher.matches()) {
      return new SecurityCode(matcher.group(1), Integer.valueOf(matcher.group(2)), matcher.group(3));
    }
    throw new IllegalArgumentException("Not a security Code");
  }

  SecurityCode(String encryptedName, int sectorId, String checksum) {
    this.encryptedName = encryptedName;
    this.sectorId = sectorId;
    this.checksum = checksum;
  }

  String getEncryptedName() {
    return encryptedName;
  }

  int getSectorId() {
    return sectorId;
  }

  String getChecksum() {
    return checksum;
  }

  boolean isValidChecksum() {
    List<CharacterCount> counted = encryptedName.replaceAll("-", "").chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .map(CharacterCount::new)
        .sorted()
        .collect(Collectors.toList());

    StringBuilder builder = new StringBuilder();
    counted.stream()
        .limit(5)
        .map(CharacterCount::getCharacter)
        .forEach(builder::append);

    boolean isValid = checksum.equals(builder.toString());
    System.out.println(String.format("Checksum: %s <> %s == %s", checksum, builder.toString(), isValid));
    return isValid;
  }

  @Override
  public String toString() {
    return "SecurityCode{" +
           "encryptedName='" + encryptedName + '\'' +
           ", sectorId=" + sectorId +
           ", checksum='" + checksum + '\'' +
           '}';
  }
}
