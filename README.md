# Minesweeper Game

## Execution

For compile the program you must install the Java jdk and enter the command:
    
    javac minesweeper.java
    
After that, it generate the file minesweeper.class and you can run the program with the command:

    java minesweeper

## Intructions

For initialize the minesweeper enter: (rows columns mines)

    Ex: 8 15 10

For uncover a cell you have to enter the cell position: (row column action)

The action should be 'U' or 'M' (it means Uncover or Mark)

     Ex: 3 6 U --> to uncover the cell
     
     Ex: 3 6 M --> to mark the cell  

## Syntax:
Unselected cell
    
    .
    
Disable cell

    -
    
Represent a mine

    *
    
Represent a flag

    p
    
Number of adjacent mines
    
    1...8
