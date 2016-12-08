package io.tripled.adventofcode.dayfive;

class SecurityDoorBruteForcerWithPosition {

  private SpecialHashCodeGenerator hashCodeGenerator;
  private char[] password = {'_','_','_','_','_','_','_','_'};

  SecurityDoorBruteForcerWithPosition(String doorId) {
    this.hashCodeGenerator = new SpecialHashCodeWithPositionGenerator(doorId);
  }

  String bruteForce() {
    do {
      String hash = hashCodeGenerator.nextHash();
      if (isPositionEmpty(indexFor(hash))) {
        password[indexFor(hash)] = valueFor(hash);
        System.out.println(new String(password));
      }
    } while (isNotComplete());

    return new String(password);

  }

  private boolean isNotComplete() {
    return new String(password).contains("_");
  }

  private boolean isPositionEmpty(int position) {
    return password[position] == '_';
  }

  private int indexFor(String hash) {
    return Integer.valueOf(String.valueOf(hash.charAt(5)));
  }

  private char valueFor(String hash) {
    return hash.charAt(6);
  }
}
