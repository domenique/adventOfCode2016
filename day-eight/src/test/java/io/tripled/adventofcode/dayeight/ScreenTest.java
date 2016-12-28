package io.tripled.adventofcode.dayeight;

import org.junit.Test;

import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ScreenTest {

  @Test
  public void whenInstantiatingShouldHaveNoPixelsBurning() throws Exception {
    Screen screen = new Screen(50, 6);

    StringWriter writer = new StringWriter();
    screen.print(writer);

    assertThat(writer.toString(), equalTo("\n" +
        "..................................................\n" +
        "..................................................\n" +
        "..................................................\n" +
        "..................................................\n" +
        "..................................................\n" +
        "..................................................\n"));
  }

  @Test
  public void whenDrawRectangleIsPerformedPixelsShouldBeLit() throws Exception {
    Screen screen = new Screen(50, 6);
    StringWriter writer = new StringWriter();

    screen.drawRect(4, 4);
    screen.print(writer);

    assertThat(writer.toString(), equalTo("\n" +
        "####..............................................\n" +
        "####..............................................\n" +
        "####..............................................\n" +
        "####..............................................\n" +
        "..................................................\n" +
        "..................................................\n"));
  }
}
