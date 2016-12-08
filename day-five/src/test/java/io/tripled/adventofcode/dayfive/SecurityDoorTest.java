package io.tripled.adventofcode.dayfive;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SecurityDoorTest {

  @Test
  public void acceptanceScenario() {
    SecurityDoorBruteForcer bruteForcer = new SecurityDoorBruteForcer("abc");

    assertThat(bruteForcer.bruteForce(), equalTo("18f47a30"));
  }

  @Test
  public void acceptanceScenarioWithPosition() {
    SecurityDoorBruteForcerWithPosition bruteForcer = new SecurityDoorBruteForcerWithPosition("abc");

    assertThat(bruteForcer.bruteForce(), equalTo("05ace8e3"));
  }
}
