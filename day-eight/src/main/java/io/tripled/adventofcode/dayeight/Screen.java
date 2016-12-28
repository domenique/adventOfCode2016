package io.tripled.adventofcode.dayeight;

import java.io.IOException;
import java.io.Writer;

class Screen {

  private char[][] pixels;
  private final int height;
  private final int width;

  Screen(int width, int height) {
    this.height = height;
    this.width = width;
    this.pixels = new char[height][width];
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j++) {
        pixels[i][j] = '.';
      }
    }

  }

  void print(Writer writer) throws IOException {
    writer.write("\n");
    for (char[] row : pixels) {
      writer.write(row);
      writer.write("\n");
      writer.flush();
    }
  }

  void drawRect(int width, int height) {
    for (int i = 0; i < Math.min(pixels.length, height); i++) {
      for (int j = 0; j < Math.min(pixels[i].length, width); j++) {
        pixels[i][j] = '#';
      }
    }
  }
}
