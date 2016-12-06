package io.tripled.adventofcode.daythree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BathRoomSecurityTest {

  private BathroomKeyController controller;

  @Before
  public void setUp() {
    controller = new BathroomKeyController();
  }

  @Test
  public void startsAtFive() {
    Digit digit = controller.getCurrentKey();

    assertThat(digit, equalTo(new Digit('5')));
  }

  @Test
  public void whenMovingUpShouldGoTo2() {
    controller.move("U");

    Digit currentKey = controller.getCurrentKey();

    assertThat(currentKey, equalTo(new Digit('5')));
  }

  @Test
  public void whenMovingRightShouldGoTo6() {
    controller.move("R");

    Digit currentKey = controller.getCurrentKey();

    assertThat(currentKey, equalTo(new Digit('6')));
  }

  @Test
  public void whenMovingDownShouldGoTo8() {
    controller.move("D");

    Digit currentKey = controller.getCurrentKey();

    assertThat(currentKey, equalTo(new Digit('5')));
  }

  @Test
  public void whenMovingLeftShouldGoTo4() {
    controller.move("L");

    Digit currentKey = controller.getCurrentKey();

    assertThat(currentKey, equalTo(new Digit('5')));
  }

  @Test
  public void whenMovingUpTwiceShouldGoTo2() {
    controller.move("UU");

    Digit currentKey = controller.getCurrentKey();

    assertThat(currentKey, equalTo(new Digit('5')));
  }

  @Test
  public void whenMovingRightTwiceShouldGoTo6() {
    controller.move("RR");

    Digit currentKey = controller.getCurrentKey();

    assertThat(currentKey, equalTo(new Digit('7')));
  }

  @Test
  public void whenMovingDownTwiceShouldGoTo8() {
    controller.move("DD");

    Digit currentKey = controller.getCurrentKey();

    assertThat(currentKey, equalTo(new Digit('5')));
  }

  @Test
  public void whenMovingLeftTwiceShouldGoTo4() {
    controller.move("LL");

    Digit currentKey = controller.getCurrentKey();

    assertThat(currentKey, equalTo(new Digit('5')));
  }

  @Test
  public void firstScenario() {
    controller.move("ULL");
    Digit firstKey = controller.getCurrentKey();
    controller.move("RRDDD");
    Digit secondKey = controller.getCurrentKey();
    controller.move("LURDL");
    Digit thirdKey = controller.getCurrentKey();
    controller.move("UUUUD");
    Digit fourthKey = controller.getCurrentKey();

//    5DB3
    assertThat(firstKey, equalTo(new Digit('5')));
    assertThat(secondKey, equalTo(new Digit('D')));
    assertThat(thirdKey, equalTo(new Digit('B')));
    assertThat(fourthKey, equalTo(new Digit('3')));
  }
}
