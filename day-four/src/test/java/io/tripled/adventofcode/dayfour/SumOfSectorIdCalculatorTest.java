package io.tripled.adventofcode.dayfour;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SumOfSectorIdCalculatorTest {

  @Test
  public void canCreateASecurityCode() throws Exception {
    SecurityCode code = SecurityCode.of("aaaaa-bbb-z-y-x-123[abxyz]");

    assertThat(code, notNullValue());
  }

  @Test
  public void canRetrieveEncryptedName() throws Exception {
    SecurityCode code = SecurityCode.of("aaaaa-bbb-z-y-x-123[abxyz]");

    assertThat(code.getEncryptedName(), equalTo("aaaaa-bbb-z-y-x"));
  }

  @Test
  public void canRetrieveSectorId() throws Exception {
    SecurityCode code = SecurityCode.of("aaaaa-bbb-z-y-x-123[abxyz]");

    assertThat(code.getSectorId(), equalTo(123));
  }

  @Test
  public void canRetrieveChecksum() throws Exception {
    SecurityCode code = SecurityCode.of("aaaaa-bbb-z-y-x-123[abxyz]");

    assertThat(code.getChecksum(), equalTo("abxyz"));
  }

  @Test
  public void isInValidChecksumBecauseOrderIsWrong() throws Exception {
    SecurityCode code = SecurityCode.of("aaaaa-bbb-zz-y-x-123[abxyz]");

    assertThat(code.isValidChecksum(), is(false));
  }

  @Test
  public void isValidChecksum2() throws Exception {
    SecurityCode code = SecurityCode.of("not-a-real-room-404[oarel]");

    assertThat(code.isValidChecksum(), is(true));
  }

  @Test
  public void isInValidChecksumIfOrderIsInvalid() throws Exception {
    SecurityCode code = SecurityCode.of("aaaaa-bbb-z-y-x-123[baxyz]");

    assertThat(code.isValidChecksum(), is(false));
  }

  @Test
  public void canDecryptTheName() throws Exception {
    SecurityCode code = SecurityCode.of("qzmt-zixmtkozy-ivhz-343[asdqq]");

    assertThat(code.decrypt(), equalTo("very encrypted name"));

  }
}