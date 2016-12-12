package io.tripled.adventofcode.daysix;

import java.io.IOException;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class NoiseCancellerTest {

  @Test
  public void failsWhenFileNotFound() {
    try (NoiseCanceller nc = new NoiseCanceller("non-existing.txt")) {
      fail();
    } catch (IOException ex) {
      assertThat(ex, instanceOf(IOException.class));
    }
  }

  @Test
  public void canOpenFile() {
    assertThat(decode("empty.txt"), nullValue());
  }

  @Test
  public void decodesFileWithOneLine() throws Exception {
    String result = decode("input-with-one-line.txt");

    assertThat(result, equalTo("abcdefgh"));
  }

  private String decode(String fileName) {
    try (NoiseCanceller nc = new NoiseCanceller(fileName)) {
      return nc.decode();
    } catch (IOException e) {
      fail();
    }
    return null;
  }
}
