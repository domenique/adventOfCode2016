import java.util.ArrayList;
import java.util.List;

class HQLocator {

  private List<Position> previousPositions;
  private Position currentPosition;
  private Position firstDuplicate;

  HQLocator() {
    previousPositions = new ArrayList<>();
    currentPosition = Position.of(0, 0, Heading.NORTH);
  }

  Position getPosition() {
    return currentPosition;
  }

  void move(Movement movement) {
    List<Position> visitedPositions = currentPosition.move(movement);
    currentPosition = visitedPositions.get(visitedPositions.size() -1 );

    for (Position cur : visitedPositions) {
      if (firstDuplicate == null && previousPositions.contains(cur)) {
        firstDuplicate = cur;
      }
    }
    previousPositions.addAll(visitedPositions);
  }

  int getDistanceFromStart() {
    return currentPosition.distance();
  }

  Position getFirstDuplicate() {
    return firstDuplicate;
  }

}
