//imports
import java.util.Scanner;

public class minesweeper {

  static int coveredCells;

  public static void main (String[] args) {

    //variables' declaration
    Scanner scanner = new Scanner(System.in);
    String[] input;
    char[][][] minesweeper;

    //instructions
    System.out.println("\n--------------------Minesweeper Game!!--------------------\n");
    System.out.println("Instructions:");
    System.out.println("--For initialize the minesweeper enter: (rows columns mines) -> (8 15 10)");
    System.out.println("--For uncover a cell you have to enter the cell position: (row column action) -> (3 6 U)");
    System.out.println("----The action should be 'U' or 'M' (it means Uncover or Mark)\n");
    System.out.println("Syntax:");
    System.out.println("--Unselected cell -> '.'");
    System.out.println("--Disable cell -> '-'");
    System.out.println("--Represent a mine -> '*'");
    System.out.println("--Represent a flag -> 'p'");
    System.out.println("--Number of adjacent mines -> '1...8'");
    System.out.println("");

    //initialize the minesweeper
    System.out.print("How do you want your minesweeper?: ");
    input = scanner.nextLine().split(" ");
    int rows = Integer.parseInt(input[0]);
    int columns = Integer.parseInt(input[1]);
    int mines = Integer.parseInt(input[2]);
    minesweeper = InitializeMinesweeper(rows, columns, mines);
    coveredCells = rows * columns;

    //play game
    do {
      DrawMinesweeper(minesweeper);
      System.out.print("Next action: ");
      input = scanner.nextLine().split(" ");
      int row = Integer.parseInt(input[0]) - 1;
      int column = Integer.parseInt(input[1]) - 1;
      char flag = input[2].toUpperCase().charAt(0);

      if (flag == 'U') {
        minesweeper = UncoverCell(minesweeper, row, column);
      }
      else if (flag == 'M') {
        minesweeper[row][column][0] = 'p';
        --coveredCells;
      }
      else {
        System.out.println("Unexpected action! Try again");
      }
      System.out.println();
    }
    while (coveredCells > 0);

  }

  static char[][][] InitializeMinesweeper(int rows, int columns, int mines) {
    char[][][] minesweeper = new char[rows][columns][2];

    for (char[][] column : minesweeper) {
      for (char[] cell : column) {
        cell[0] = '.';
        cell[1] = '-';
      }
    }

    int row = 0, column = 0;
    while (mines > 0) {
      row = (int) (Math.random() * rows);
      column = (int) (Math.random() * columns);

      if (minesweeper[row][column][1] != '*'){
        minesweeper[row][column][1] = '*';
        --mines;
        minesweeper = AssignNumbers(minesweeper, row, column);
      }
    }

    return minesweeper;
  }

  static char[][][] AssignNumbers(char[][][] minesweeper, int row, int column) {
    int value;
    char character;

    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = column - 1; j <= column + 1; j++) {
        try {
          character = minesweeper[i][j][1];
          if (character != '*') {
            value = (character == '-') ? 0 : Character.getNumericValue(character);
            minesweeper[i][j][1] = Character.forDigit(++value, 10);
          }
        }
        catch (ArrayIndexOutOfBoundsException e) {
        }
      }
    }
    return minesweeper;
  }

  static char[][][] UncoverCell(char[][][] minesweeper, int row, int column) {
    char uncoveredCell = minesweeper[row][column][1];
    if (minesweeper[row][column][0] != uncoveredCell) {
      if (uncoveredCell == '-') {
        minesweeper[row][column][0] = uncoveredCell;
        --coveredCells;
        for (int i = row - 1; i <= row + 1; i++) {
          for (int j = column - 1; j <= column + 1; j++){
            try {
              minesweeper = UncoverCell(minesweeper, i, j);
            }
            catch (ArrayIndexOutOfBoundsException e) {
              
            }
          }
        }


      }
      else if (uncoveredCell == '*') {
        DrawMines(minesweeper);
        coveredCells = 0;
      }
      else {
        minesweeper[row][column][0] = uncoveredCell;
        --coveredCells;
      }
    }
    return minesweeper;
  }

  static void DrawMinesweeper(char[][][] minesweeper) {
    for (char[][] column : minesweeper) {
      for (char[] cell : column) {
        System.out.print(cell[0] + " ");
      }
      System.out.println("");
    }
  }

  static void DrawMines(char[][][] minesweeper) {
    System.out.println();
    for (char[][] column : minesweeper) {
      for (char[] cell : column) {
        if (cell[1] == '*') {
          System.out.print(cell[1] + " ");
        }
        else {
          System.out.print(cell[0] + " ");
        }
      }
      System.out.println();
    }
    System.out.println("You Lose!! Try again!\n");
  }
}
