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
    try (NoiseCanceller nc = new NoiseCanceller("non-existing.txt", 8)) {
      fail();
    } catch (IOException ex) {
      assertThat(ex, instanceOf(IOException.class));
    }
  }

  @Test
  public void canOpenFile() {
    assertThat(decode("empty.txt", 8), nullValue());
  }

  @Test
  public void decodesFileWithOneLine() throws Exception {
    String result = decode("input-with-one-line.txt", 8);

    assertThat(result, equalTo("abcdefgh"));
  }

  @Test
  public void decodesFileWithMultipleLines() {
    String result = decode("input-with-multiple-lines.txt", 8);

    assertThat(result, equalTo("bbbbbbbb"));
  }

  @Test
  public void decodesFileForAcceptance() {
    String result = decode("input-for-acceptance.txt", 6);

    assertThat(result, equalTo("easter"));

  }

  @Test
  public void decodesFileForAcceptanceWithLowestChars() {
    String result = decodeWithLowest("input-for-acceptance.txt", 6);

    assertThat(result, equalTo("advent"));

  }

  private String decode(String fileName, int columnSize) {
    try (NoiseCanceller nc = new NoiseCanceller(fileName, columnSize)) {
      return nc.decodeWithHigestCountedChars();
    } catch (IOException e) {
      fail();
    }
    return null;
  }

  private String decodeWithLowest(String fileName, int columnSize) {
    try (NoiseCanceller nc = new NoiseCanceller(fileName, columnSize)) {
      return nc.decodeWithLowestCountedChars();
    } catch (IOException e) {
      fail();
    }
    return null;
  }
}
