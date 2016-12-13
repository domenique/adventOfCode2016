package io.tripled.adventofcode.daysix;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class NoiseCanceller implements Closeable {

  private BufferedReader reader;
  private Columns columns;

  NoiseCanceller(String fileName, int columnSize) throws IOException {
    this.reader = openFile(fileName);
    this.columns = new Columns(columnSize);

  }

  String decodeWithHigestCountedChars() throws IOException {
    readIntoColumns();

    if (!columns.isEmpty()) {
      return columns.createStringWithHighestCountedCharPerColumn();
    } else {
      return null;
    }
  }

  String decodeWithLowestCountedChars() throws IOException {
    readIntoColumns();

    if (!columns.isEmpty()) {
      return columns.createStringWithLowestCountedCharPerColumn();
    } else {
      return null;
    }
  }

  private void readIntoColumns() throws IOException {
    String line = reader.readLine();

    while (line != null) {
      char[] chars = line.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        columns.addCharAtColumn(chars[i], i);
      }

      line = reader.readLine();
    }
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
