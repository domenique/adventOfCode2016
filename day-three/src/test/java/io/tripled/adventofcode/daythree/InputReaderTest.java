package io.tripled.adventofcode.daythree;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class InputReaderTest {

  @Test
  public void handlesMissingFiles() throws IOException {
    SimpleInputReader input = new SimpleInputReader("nonexisting.txt");

    CandidateTriangle triagle = input.read();

    assertThat(triagle, nullValue());
  }

  @Test
  public void canReadAnEmptyFile() throws IOException {
    SimpleInputReader input = new SimpleInputReader("empty-file.txt");

    CandidateTriangle triagle = input.read();

    assertThat(triagle, nullValue());
  }

  @Test
  public void canReadOneInput() throws IOException {
    SimpleInputReader input = new SimpleInputReader("one-line.txt");

    CandidateTriangle triagle = input.read();

    assertThat(triagle, notNullValue());
  }
}
