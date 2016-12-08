package io.tripled.adventofcode.dayfour;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

  private SecurityCode(String encryptedName, int sectorId, String checksum) {
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
    StringBuilder builder = new StringBuilder();
    List<CharacterCount> characterCounts = encryptedName.replaceAll("-", "").chars()
        .mapToObj(c -> (char) c)
        .collect(toMapOfCharacterWithCount())
        .entrySet().stream()
        .map(CharacterCount::new)
        .sorted()
        .collect(toList());

    characterCounts.stream()
        .limit(5)
        .map(CharacterCount::getCharacter)
        .forEach(builder::append);

    boolean isValid = checksum.equals(builder.toString());
    return isValid;
  }

  String decrypt() {
    String result = "";
    for (char c : encryptedName.toCharArray()) {
      if (c == '-') {
        result += ' ';
      } else {
        result += Character.toString((char) (((c - 'a' + sectorId) % 26) + 'a'));
      }
    }

    return result;
  }

  private Collector<Character, ?, Map<Character, Long>> toMapOfCharacterWithCount() {
    return Collectors.groupingBy(Function.identity(), Collectors.counting());
  }

  @Override
  public String toString() {
    return "SecurityCode{" +
        "encryptedName='" + encryptedName + '\'' +
        ", sectorId=" + sectorId +
        ", checksum='" + checksum + '\'' +
        ", isValid='" + isValidChecksum() + '\'' +
        ", decrypted='" + decrypt() + '\'' +
        '}';
  }
}
