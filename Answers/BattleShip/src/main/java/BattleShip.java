import java.util.Scanner;
import java.util.Random;

/**
  The BattleShip class manages the gameplay of the Battleship game between two players.
  It includes methods to manage grids, turns, and check the game status.
 */
public class BattleShip {

    // Grid size for the game
    static final int GRID_SIZE = 10;

    // Player 1's main grid containing their ships
    static char[][] player1Grid = new char[GRID_SIZE][GRID_SIZE];

    // Player 2's main grid containing their ships
    static char[][] player2Grid = new char[GRID_SIZE][GRID_SIZE];

    // Player 1's tracking grid to show their hits and misses
    static char[][] player1TrackingGrid = new char[GRID_SIZE][GRID_SIZE];

    // Player 2's tracking grid to show their hits and misses
    static char[][] player2TrackingGrid = new char[GRID_SIZE][GRID_SIZE];

    // Scanner object for user input
    static Scanner input = new Scanner(System.in);

    /**
      The main method that runs the game loop.
      It initializes the grids for both players, places ships randomly, and manages turns.
      The game continues until one player's ships are completely sunk.
     */
    public static void main(String[] args) {
        // Initialize grids for both players
        initializeGrid(player1Grid); // halle
        initializeGrid(player2Grid); // halle
        initializeGrid(player1TrackingGrid); // halle
        initializeGrid(player2TrackingGrid); // halle

        // Place ships randomly on each player's grid
        placeShips(player1Grid); // halle
        placeShips(player2Grid); // halle

        // Variable to track whose turn it is
        boolean player1Turn = true;

        // Main game loop, runs until one player's ships are all sunk
        while (!isGameOver()) {
            if (player1Turn) {
                System.out.println("Player 1's turn:");
                printGrid(player1TrackingGrid); // halle
                playerTurn(player2Grid, player1TrackingGrid); // halle
            } else {
                System.out.println("Player 2's turn:");
                printGrid(player2TrackingGrid); // halle
                playerTurn(player1Grid, player2TrackingGrid); // halle
            }
            player1Turn = !player1Turn;
        }

        System.out.println("Game Over!");
        if (allShipsSunk(player1Grid))
            System.out.println("Player 2 win!!");
        else 
            System.out.println("Player 1 win!1");
    }

    /**
      Initializes the grid by filling it with water ('~').

      @param grid The grid to initialize.
     */
    static void initializeGrid(char[][] grid) {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                grid[i][j] = '~';
            }
        }
    }

    /**
      Places ships randomly on the given grid.
      This method is called for both players to place their ships on their respective grids.

      @param grid The grid where ships need to be placed.
     */
    static void placeShips(char[][] grid) {        
    int[] sizeOfShip = {2, 2, 3, 4, 5};
    Random rand = new Random();
    for (int size : sizeOfShip) {
        boolean placed = false;
        String str1 = rand.nextBoolean() ? "ofoghy" : "amodi";
        String str2 = rand.nextBoolean() ? "manfi" : "mothbat";
        while (!placed) {
            switch (str1) {
                case "ofoghy" -> {
                    int randRow = rand.nextInt(10);
                    int randColumn = rand.nextInt(11 - size);
                    boolean canPlace = true;
                    switch (str2) {
                        case "mothbat" -> {
                            for (int i=0; i<size; i++) {
                                if (grid[randRow][randColumn + i] == 'S') {
                                    canPlace = false;
                                    break;
                                }
                            }
                            if (canPlace) {
                                for (int i=0; i<size; i++) 
                                    grid[randRow][randColumn + i] = 'S';
                                placed = true;
                            }
                        }

                        case "manfi" -> {
                            for (int i=0; i<size; i++) {
                                if (randColumn - i < 0 || grid[randRow][randColumn - i] == 'S') {
                                    canPlace = false;
                                    break;
                                }
                            }
                            if (canPlace) {
                                for (int i=size-1; i>=0; i--) 
                                    grid[randRow][randColumn - i] = 'S';
                                placed = true;
                            }
                        }
                    } 
                }
                case "amodi" -> {
                    int randRow = rand.nextInt(11 - size);
                    int randColumn = rand.nextInt(10);
                    boolean canPlace = true;
                    switch (str2) {
                        case "mothbat" -> {
                            for (int i=0; i<size; i++) {
                                if (grid[randRow + i][randColumn] == 'S') {
                                    canPlace = false;
                                    break;
                                } 
                            }
                            if (canPlace) {
                                for (int i=0; i<size; i++) {
                                    grid[randRow + i][randColumn] = 'S';
                                }
                                placed = true;
                            }
                        }
                        case "manfi" -> {
                            for (int i=0; i<size; i++) {
                                if (randRow - i < 0 || grid[randRow - i][randColumn] == 'S') {
                                    canPlace = false;
                                    break;
                                }
                            }
                            if (canPlace) {
                                for (int i=size-1; i>=0; i--) {
                                    grid[randRow - i][randColumn] = 'S';
                                }
                                placed = true;
                            }
                        }
                    }
                }
            }
        }
    }
    }

    /**
      Checks if a ship can be placed at the specified location on the grid.
      This includes checking the size of the ship, its direction (horizontal or vertical),
      and if there's enough space to place it.

      @param grid The grid where the ship is to be placed.
      @param row The starting row for the ship.
      @param col The starting column for the ship.
      @param size The size of the ship.
      @param horizontal The direction of the ship (horizontal or vertical).
      @return true if the ship can be placed at the specified location, false otherwise.
     */
    
    /**
      Manages a player's turn, allowing them to attack the opponent's grid
      and updates their tracking grid with hits or misses.

      @param opponentGrid The opponent's grid to attack.
      @param trackingGrid The player's tracking grid to update.
     */
    static void playerTurn(char[][] opponentGrid, char[][] trackingGrid) {
        int row = 0;
        int column = 0;
        Boolean bool = false;

        while (!bool) {
            try {
                System.out.print("Enter row (1-10) : ");
                row = input.nextInt();
                System.out.print("Enter column (1-10) : ");
                column = input.nextInt();
                input.nextLine();
                if (row < 1 || row > 10 || column < 1 || column > 10)
                    System.out.print("Invalid input (input row and column between '1' and '10'), try again!!");

                else if (trackingGrid[row-1][column-1] == 'O' || trackingGrid[row-1][column-1] == 'X')
                    System.out.print("Invalid input (you have already attacked this location), try again!!");
                else
                    bool = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input (Enter number only), try again!!");
                input.nextLine();
            }
        }
        if (opponentGrid[row-1][column-1] == 'S') {
            System.out.println("Hit!!");
            opponentGrid[row-1][column-1] = 'X';
            trackingGrid[row-1][column-1] = 'X';
        }
        else {
            System.out.println("Missed!!");
            trackingGrid[row-1][column-1] = 'O';
        }

    }

    /**
      Checks if the game is over by verifying if all ships are sunk.

      @return true if the game is over (all ships are sunk), false otherwise.
     */
    static boolean isGameOver() {
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (player1Grid[i][j] == 'S')
                    count1++;
            }
        }
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (player2Grid[i][j] == 'S')
                    count2++;
            }
        }

        if (count1 != 0 && count2 != 0)
            return false;
        else 
            return true;
    }

    /**
      Checks if all ships have been destroyed on a given grid.

      @param grid The grid to check for destroyed ships.
      @return true if all ships are sunk, false otherwise.
     */
    static boolean allShipsSunk(char[][] grid) {
        int count = 0;
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (grid[i][j] == 'S')
                    count++;
            }
        }
        if (count == 0) 
            return true;
        else
            return false;
    }

    /**
      Prints the current state of the player's tracking grid.
      This method displays the grid, showing hits, misses, and untried locations.

      @param grid The tracking grid to print.
     */
    static void printGrid(char[][] grid) {
        System.out.print("    " + 1);
        for (int i=2; i<=10; i++) {
            System.out.print("   " + i);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            if (i != 9) 
                System.out.print((i+1) + " ");
            else 
                System.out.print(10);
            for (int j = 0; j < 10; j++) {
                System.out.print("|");
                System.out.print(" " + grid[i][j] + " ");
                if (j == 9) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != 9) {
                for (int j = 0; j < 14; j++) {
                    System.out.print("  -");
                    // if (j == 9)
                    //     System.out.print("-");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
