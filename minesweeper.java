//imports
import java.util.Scanner;

public class minesweeper {
  public static void main (String[] args) {

    //variables' declaration
    Scanner scanner = new Scanner(System.in);
    char[] input;
    char[][][] minesweeper;
    int coveredCells;

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
    System.out.println();

    //initialize the minesweeper
    System.out.print("How do you want your minesweeper?: ");
    input = scanner.nextLine().split(" ");
    int rows = Integer.parseInt(input[0]);
    int columns = Integer.parseInt(input[1]);
    int mines = Integer.parseInt(input[2]);
    minesweeper = InitializeMinesweeper(rows, columns, mines);
    coveredCells = rows * columns;

    do {


    }
    while (coveredCells);

  }

  static char[][][] InitializeMinesweeper(int rows, int columns, int mines) {
    char[][][] minesweeper = new char[rows][columns][2];

    for (char[][] column : minesweeper) {
      for (char[] cell : column) {
        cell[0] = '.';
        cell[1] = '';
      }
    }

    int row = 0, column = 0;
    while (mines) {
      row = (int) (Math.random() * rows);
      column = (int) (Math.random() * columns);

      if (minesweeper[row][column][1] != '*'){
        minesweeper[row][column][1] = '*';
        --mines;
      }
    }

    return minesweeper;
  }
}
