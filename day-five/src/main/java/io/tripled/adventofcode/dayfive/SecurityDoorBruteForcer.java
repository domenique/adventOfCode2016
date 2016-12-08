package io.tripled.adventofcode.dayfive;

class SecurityDoorBruteForcer {

  private SpecialHashCodeGenerator hashCodeGenerator;

  SecurityDoorBruteForcer(String doorId) {
    this.hashCodeGenerator = new SpecialHashCodeGenerator(doorId);
  }


  String bruteForce() {
    StringBuilder password = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      password.append(hashCodeGenerator.nextHash().charAt(5));
    }

    return password.toString();
  }
}
