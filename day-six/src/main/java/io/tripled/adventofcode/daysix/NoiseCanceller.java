package io.tripled.adventofcode.daysix;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class NoiseCanceller implements Closeable {

  private BufferedReader reader;

  NoiseCanceller(String fileName) throws IOException {
    this.reader = openFile(fileName);
  }

  String decode() throws IOException {
    return reader.readLine();
  }

  private BufferedReader openFile(String fileName) throws IOException {
    InputStream stream = ClassLoader.getSystemResourceAsStream(fileName);
    if (stream != null) {
      return new BufferedReader(new InputStreamReader(stream));
    }
    throw new IOException("File could not be opened.");
  }

  @Override
  public void close() throws IOException {
    this.reader.close();
  }
}
