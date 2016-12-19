package io.tripled.adventofcode.dayseven;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IPv7AddressTest {

  @Test
  public void canInstantiate() throws Exception {
    new IPv7Address("aaa[aaaa]aaaa");
  }

  @Test
  public void supportsTls() throws Exception {
    IPv7Address address = new IPv7Address("abba[sdfsd]sdfsfsdf");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(true));
  }

  @Test
  public void supportsTlsWhenAbbaInLastLabel() throws Exception {
    IPv7Address address = new IPv7Address("abcd[sdfsd]sdfsfabbasdf");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(true));
  }

  @Test
  public void supportsTlsWhenAbbaInLastLabelAtLastPosition() throws Exception {
    IPv7Address address = new IPv7Address("abcd[sdfsd]sdfsfsdfabba");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(true));
  }

  @Test
  public void supportsTlsWhenLabelIsSmallerThen4Chars() throws Exception {
    IPv7Address address = new IPv7Address("abc[sdfsd]sdfsfsdfabba");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(true));
  }

  @Test
  public void doesNotSupportTlsWhenHyperNetContainsAbba() throws Exception {
    IPv7Address address = new IPv7Address("abcd[fddf]sdfsfsdfabba");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(false));
  }

  @Test
  public void firstScenario() throws Exception {
    // abba[mnop]qrst supports TLS (abba outside square brackets).
    IPv7Address address = new IPv7Address("abba[mnop]qrst");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(true));
  }

  @Test
  public void secondScenario() throws Exception {
    // abcd[bddb]xyyx does not support TLS (bddb is within square brackets, even though xyyx is outside square brackets).
    IPv7Address address = new IPv7Address("abcd[bddb]xyyx");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(false));
  }

  @Test
  public void thirdScenario() throws Exception {
    // aaaa[qwer]tyui does not support TLS (aaaa is invalid; the interior characters must be different).
    IPv7Address address = new IPv7Address("aaaa[qwer]tyui");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(false));
  }

  @Test
  public void fourthScenario() throws Exception {
    // ioxxoj[asdfgh]zxcvbn supports TLS (oxxo is outside square brackets, even though it's within a larger string).
    IPv7Address address = new IPv7Address("ioxxoj[asdfgh]zxcvbn");

    boolean supportsTls = address.supportsTls();

    assertThat(supportsTls, is(true));
  }
}
