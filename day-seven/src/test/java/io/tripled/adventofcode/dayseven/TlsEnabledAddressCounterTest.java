package io.tripled.adventofcode.dayseven;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TlsEnabledAddressCounterTest {

  @Test
  public void doesNotFailWhenFileDoesNotExist() throws IOException {
    int count;
    try (TlsEnabledAddressCounter counter = new TlsEnabledAddressCounter("nonexisting.txt")) {
      count = counter.count();
    }
    assertThat(count, equalTo(0));
  }

  @Test
  public void canCountTlsSupportedIpAddressesWhenFileEmpty() throws IOException {
    int count;
    try (TlsEnabledAddressCounter counter = new TlsEnabledAddressCounter("empty.txt")) {
      count = counter.count();
    }

    assertThat(count, equalTo(0));
  }

  @Test
  public void canCountTlsSupportedIpAddressesWhenFileContainsOneTlsSupported() throws IOException {
    int count;
    try (TlsEnabledAddressCounter counter = new TlsEnabledAddressCounter("one-tls-supported.txt")) {
      count = counter.count();
    }

    assertThat(count, equalTo(1));
  }

  @Test
  public void canCountTlsSupportedIpAddressesWhenFileContainsOneNotTlsSupported() throws IOException {
    int count;
    try (TlsEnabledAddressCounter counter = new TlsEnabledAddressCounter("one-tls-not-supported.txt")) {
      count = counter.count();
    }

    assertThat(count, equalTo(0));
  }
}