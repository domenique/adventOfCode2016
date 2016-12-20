package io.tripled.adventofcode.dayseven;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class TlsEnabledAddressCounter implements Closeable {

  private BufferedReader reader;

  TlsEnabledAddressCounter(String fileName) {
    InputStream stream = ClassLoader.getSystemResourceAsStream(fileName);
    if (stream != null) {
      reader = new BufferedReader(new InputStreamReader(stream));
    }
  }

  int count() {
    if (reader != null) {
      return Math.toIntExact(reader.lines()
          .map(IPv7Address::new)
          .filter(IPv7Address::supportsTls)
          .count());
    }
    return 0;
  }


  @Override
  public void close() throws IOException {
    if (reader != null) {
      reader.close();
    }
  }
}
