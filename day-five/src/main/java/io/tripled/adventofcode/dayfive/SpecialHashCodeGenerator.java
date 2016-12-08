package io.tripled.adventofcode.dayfive;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

class SpecialHashCodeGenerator {
  private String doorId;
  private int counter = -1;
  private final MessageDigest messageDigest;

  SpecialHashCodeGenerator(String doorId) {
    this.doorId = doorId;
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new HashCodeGeneratorCannotBeInstantiatedException();
    }
  }

  String nextHash() {
    String hash = md5(doorId + ++counter);
    while (!matchesPattern(hash)) {
      hash = md5(doorId + ++counter);
    }
    System.out.println(String.format("c(%s) : %s", counter, hash));
    return hash;
  }

  private String md5(String stringToHash) {
    messageDigest.update(stringToHash.getBytes(), 0, stringToHash.length());
    BigInteger digest = new BigInteger(1, messageDigest.digest());
    return String.format("%1$032x", digest);
  }

  protected boolean matchesPattern(String hash) {
    return hash.startsWith("00000");
  }
}
