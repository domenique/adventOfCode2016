package io.tripled.adventofcode.dayfive;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class SpecialHashCodeGeneratorTest {
  @Test
  public void nextHashReturnsTheNextHash() throws Exception {
    SpecialHashCodeGenerator g = new SpecialHashCodeGenerator("abc");

    String hash = g.nextHash();
    assertThat(hash, notNullValue());
    assertThat(hash, startsWith("000001"));

    String hash2 = g.nextHash();
    assertThat(hash2, notNullValue());
    assertThat(hash2, startsWith("000008"));
  }

  @Test
  public void generatedHashShouldStartWith5Zeros() throws Exception {
    SpecialHashCodeGenerator g = new SpecialHashCodeGenerator("abc");
    String hash = g.nextHash();
    assertThat(hash, notNullValue());
    assertThat(hash, startsWith("000001"));
  }
}
