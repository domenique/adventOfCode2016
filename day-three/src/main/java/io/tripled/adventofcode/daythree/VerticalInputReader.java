package io.tripled.adventofcode.daythree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerticalInputReader implements InputReader {

  private final String regex = "[\\s]{2}([\\d|\\s]{3})[\\s]{2}([\\d|\\s]{3})[\\s]{2}([\\d|\\s]{3})";
  private final Pattern pattern = Pattern.compile(regex);

  private String fileName;
  private BufferedReader reader;
  private List<CandidateTriangle> triangles = new ArrayList<>();

  public VerticalInputReader(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public CandidateTriangle read() throws IOException {
    if (reader == null) {
      openFile();
    }

    if (triangles.size() < 1 && reader != null) {
      String line = reader.readLine();
      String line2 = reader.readLine();
      String line3 = reader.readLine();

      if (line == null || line2 == null || line3 == null) {
        return null;
      }
      triangles.addAll(createTriangles(line, line2, line3));
    }

    try {
      return triangles.remove(0);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  private List<CandidateTriangle> createTriangles(String line1, String line2, String line3) throws IOException {
    List<CandidateTriangle> triangles = new ArrayList<>();
    Matcher matcher1 = pattern.matcher(line1);
    Matcher matcher2 = pattern.matcher(line2);
    Matcher matcher3 = pattern.matcher(line3);

    if (matcher1.matches() && matcher2.matches() && matcher3.matches()) {
      triangles.add(createTriangle(matcher1.group(1), matcher2.group(1), matcher3.group(1)));
      triangles.add(createTriangle(matcher1.group(2), matcher2.group(2), matcher3.group(2)));
      triangles.add(createTriangle(matcher1.group(3), matcher2.group(3), matcher3.group(3)));
    }

    return triangles;
  }

  private CandidateTriangle createTriangle(String side1, String side2, String side3) throws IOException {
    return new CandidateTriangle(toInt(side1),
        toInt(side2),
        toInt(side3));
  }

  @Override
  public void close() throws IOException {

  }

  private void openFile() {
    InputStream stream = ClassLoader.getSystemResourceAsStream(fileName);
    if (stream != null) {
      reader = new BufferedReader(new InputStreamReader(stream));
    }
  }

  private int toInt(String input) {
    return Integer.valueOf(input.trim());
  }
}
