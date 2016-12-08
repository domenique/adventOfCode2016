package io.tripled.adventofcode.daythree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SimpleInputReader implements InputReader {

  private final String regex = "[\\s]{2}([\\d|\\s]{3})[\\s]{2}([\\d|\\s]{3})[\\s]{2}([\\d|\\s]{3})";
  private final Pattern pattern = Pattern.compile(regex);

  private BufferedReader reader;
  private String fileName;

  SimpleInputReader(String fileName) {
    this.fileName = fileName;
  }



  @Override
  public CandidateTriangle read() throws IOException {
    if (reader == null) {
      openFile();
    }

    if (reader != null) {
      String line = reader.readLine();
      if (line == null) {
        return null;
      }
      return createTriangle(line);
    }
    return null;
  }

  @Override
  public void close() throws IOException {
    if (reader != null) {
      reader.close();
    }
  }

  private void openFile() {
    InputStream stream = ClassLoader.getSystemResourceAsStream(fileName);
    if (stream != null) {
      reader = new BufferedReader(new InputStreamReader(stream));
    }
  }

  private CandidateTriangle createTriangle(String line) throws IOException {
    Matcher matcher = pattern.matcher(line);
    if (matcher.matches()) {
      return new CandidateTriangle(toInt(matcher.group(1)),
          toInt(matcher.group(2)),
          toInt(matcher.group(3)));
    }
    return null;
  }

  private int toInt(String input) {
    return Integer.valueOf(input.trim());
  }
}
