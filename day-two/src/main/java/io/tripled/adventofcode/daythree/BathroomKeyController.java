package io.tripled.adventofcode.daythree;

class BathroomKeyController {

  private Digit digits[][];
  private Digit currentDigit;

  BathroomKeyController() {

    /*
       1
     2 3 4
   5 6 7 8 9
     A B C
       D
     */

    digits = new Digit[5][5];
    digits[0][0] = null;
    digits[1][0] = null;
    digits[2][0] = new Digit('1', 2, 0);
    digits[3][0] = null;
    digits[4][0] = null;

    digits[0][1] = null;
    digits[1][1] = new Digit('2',1,1);
    digits[2][1] = new Digit('3', 2, 1);
    digits[3][1] = new Digit('4', 3, 1);
    digits[4][1] = null;

    digits[0][2] = new Digit('5', 0, 2);
    digits[1][2] = new Digit('6', 1, 2);
    digits[2][2] = new Digit('7', 2, 2);
    digits[3][2] = new Digit('8', 3, 2);
    digits[4][2] = new Digit('9', 4, 2);

    digits[0][3] = null;
    digits[1][3] = new Digit('A', 1, 3);
    digits[2][3] = new Digit('B', 2, 3);
    digits[3][3] = new Digit('C', 3, 3);
    digits[4][3] = null;

    digits[0][4] = null;
    digits[1][4] = null;
    digits[2][4] = new Digit('D', 2, 4);
    digits[3][4] = null;
    digits[4][4] = null;

    currentDigit = digits[0][2];
  }

  Digit getCurrentKey() {
    return currentDigit;
  }

  void move(String movement) {
    for (char c : movement.toCharArray()) {
      switch (c) {
        case 'U':
          if (digits[currentDigit.getX()][Math.max(currentDigit.getY() - 1, 0)] != null) {
            currentDigit = digits[currentDigit.getX()][Math.max(currentDigit.getY() - 1, 0)];
          }
          break;
        case 'R':
          if (digits[Math.min(currentDigit.getX() + 1, 4)][currentDigit.getY()] != null) {
            currentDigit = digits[Math.min(currentDigit.getX() + 1, 4)][currentDigit.getY()];
          }
          break;
        case 'D':
          if (digits[currentDigit.getX()][Math.min(currentDigit.getY() + 1, 4)] != null) {
            currentDigit = digits[currentDigit.getX()][Math.min(currentDigit.getY() + 1, 4)];
          }
          break;
        case 'L':
          if (digits[Math.max(currentDigit.getX() - 1, 0)][currentDigit.getY()] != null) {
            currentDigit = digits[Math.max(currentDigit.getX() - 1, 0)][currentDigit.getY()];
          }
          break;
      }
    }
  }
}
