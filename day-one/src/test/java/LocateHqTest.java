import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LocateHqTest {

  private HQLocator locator;

  @Before
  public void setUp() {
    locator = new HQLocator();
  }

  @Test
  public void startsAtInitialPosition() {
    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(0, 0, Heading.NORTH)));
  }

  @Test
  public void canMoveOnePositionToTheRight() {
    locator.move(Movement.parse("R1"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(1, 0, Heading.EAST)));
  }

  @Test
  public void canMoveOnePositionToTheLeft() {
    locator.move(Movement.parse("L1"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(-1, 0, Heading.WEST)));
  }

  @Test
  public void canMoveTwoPositionsToTheLeft() {
    locator.move(Movement.parse("L2"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(-2, 0, Heading.WEST)));
  }

  @Test
  public void canMoveTwoPositionsToTheRight() {
    locator.move(Movement.parse("R2"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(2, 0, Heading.EAST)));
  }

  @Test
  public void canMoveTwiceOnePositionsToTheLeft() {
    locator.move(Movement.parse("L1"));
    locator.move(Movement.parse("L1"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(-1, -1, Heading.SOUTH)));
  }

  @Test
  public void canMoveTwiceOnePositionsToTheRight() {
    locator.move(Movement.parse("R1"));
    locator.move(Movement.parse("R1"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(1, -1, Heading.SOUTH)));
  }

  @Test
  public void firstScenario() {
    locator.move(Movement.parse("R2"));
    locator.move(Movement.parse("L3"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(2, 3, Heading.NORTH)));
    assertThat(locator.getDistanceFromStart(), equalTo(5));
  }

  @Test
  public void secondScenario() {
    locator.move(Movement.parse("R2"));
    locator.move(Movement.parse("R2"));
    locator.move(Movement.parse("R2"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(0, -2, Heading.WEST)));
    assertThat(locator.getDistanceFromStart(), equalTo(2));
  }

  @Test
  public void thirdScenario() {

    locator.move(Movement.parse("R5"));
    locator.move(Movement.parse("L5"));
    locator.move(Movement.parse("R5"));
    locator.move(Movement.parse("R3"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(10, 2, Heading.SOUTH)));
    assertThat(locator.getDistanceFromStart(), equalTo(12));
  }

  @Test
  public void fourthScenario() {

    locator.move(Movement.parse("R8"));
    locator.move(Movement.parse("R4"));
    locator.move(Movement.parse("R4"));
    locator.move(Movement.parse("R8"));

    Position position = locator.getPosition();

    assertThat(position, equalTo(Position.of(4, 4, Heading.SOUTH)));
    assertThat(locator.getDistanceFromStart(), equalTo(8));
    assertThat(locator.getFirstDuplicate().distance(), equalTo(4));
  }
}
