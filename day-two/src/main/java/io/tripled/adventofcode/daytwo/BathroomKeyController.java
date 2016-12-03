package io.tripled.adventofcode.daytwo;

class BathroomKeyController {

  private Digit digits[][];
  private Digit currentDigit;

  BathroomKeyController() {
    digits = new Digit[3][3];
    digits[0][0] = new Digit(1, 0, 0);
    digits[1][0] = new Digit(2, 1, 0);
    digits[2][0] = new Digit(3, 2, 0);

    digits[0][1] = new Digit(4, 0, 1);
    digits[1][1] = new Digit(5, 1, 1);
    digits[2][1] = new Digit(6, 2, 1);

    digits[0][2] = new Digit(7, 0, 2);
    digits[1][2] = new Digit(8, 1, 2);
    digits[2][2] = new Digit(9, 2, 2);

    currentDigit = digits[1][1];
  }

  Digit getCurrentKey() {
    return currentDigit;
  }

  void move(String movement) {
    for (char c : movement.toCharArray()) {
      switch (c) {
        case 'U':
          currentDigit = digits[currentDigit.getX()][Math.max(currentDigit.getY() - 1, 0)];
          break;
        case 'R':
          currentDigit = digits[Math.min(currentDigit.getX() + 1, 2)][currentDigit.getY()];
          break;
        case 'D':
          currentDigit = digits[currentDigit.getX()][Math.min(currentDigit.getY() + 1, 2)];
          break;
        case 'L':
          currentDigit = digits[Math.max(currentDigit.getX() - 1, 0)][currentDigit.getY()];
          break;
      }
    }
  }
}
