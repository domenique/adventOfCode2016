package io.tripled.adventofcode.daysix;

class Columns {

  CharacterColumn[] columns;

  public Columns(int size) {
    columns = new CharacterColumn[size];
  }

  void addCharAtColumn(char aChar, int index) {
    if (columns[index] == null) {
      columns[index] = new CharacterColumn();
    }
    columns[index].addCharacter(aChar);
  }


   String createStringWithHighestCountedCharPerColumn() {
    String result = "";
    for (CharacterColumn characterColumn : columns) {
      result += characterColumn.getHighestCountedChar();
    }
    return result;
  }

  String createStringWithLowestCountedCharPerColumn() {
    String result = "";
    for (CharacterColumn characterColumn : columns) {
      result += characterColumn.getLowestCountedChar();
    }
    return result;
  }

   boolean isEmpty() {
     for (CharacterColumn column : columns) {
       if (column != null) {
         return false;
       }
     }
     return true;
  }
}
