package io.tripled.adventofcode.dayseven;

import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IPv7AddressTest {

  @Test
  public void canInstantiate() throws Exception {
    IPv7Address address = new IPv7Address("aaa[aaaa]aaaa");
  }

  @Test
  public void validates() throws Exception {
    IPv7Address address = new IPv7Address("aaaa[sdfsd]sdfsfsdf");

    boolean isValid = address.isValid();

    assertThat(isValid, is(true));
  }

  @Test
  public void splitsAddressIntoLabels() throws Exception {
    IPv7Address address = new IPv7Address("abcd[sdfsd]sdfsfsdf");

    List<IPv7Label> labels = address.getLabels();

    assertThat(labels.size(), equalTo(3));
  }
}
