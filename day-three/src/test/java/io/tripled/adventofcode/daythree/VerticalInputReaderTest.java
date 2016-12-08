package io.tripled.adventofcode.daythree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VerticalInputReaderTest {

  private VerticalInputReader reader;

  @Before
  public void setUp() throws Exception {
    reader = new VerticalInputReader("vertical-input.txt");
  }

  @Test
  public void canReadVerticalInput() throws Exception {

    CandidateTriangle first = reader.read();
    CandidateTriangle second = reader.read();
    CandidateTriangle third = reader.read();

    assertThat(first.isValid(), is(true));
    assertThat(second.isValid(), is(true));
    assertThat(third.isValid(), is(false));
  }
}
