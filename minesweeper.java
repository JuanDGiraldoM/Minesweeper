//imports
import java.util.Scanner;

public class minesweeper {
  public static void main (String[] args) {

    //variables' declaration
    Scanner scanner = new Scanner(System.in);
    char[] input;
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
    System.out.println();
}
