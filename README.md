# BattleShip — Mini Project

## Project Introduction
The BattleShip game is a two-player game traditionally played on paper. In this project, you will implement a simple version of this game in the terminal. The goal of this project is to practice object-oriented programming (OOP) concepts and strengthen your coding skills in Java.

---

## BattleShip Game Rules
1. **Game Board:** Each player has a square grid, usually 10x10.
   - Rows are labeled with numbers (0 to 9), and columns are labeled with letters (A to J).

2. **Ship Placement:**
   - Each player must place a number of ships on their board.
   - Ships can be placed horizontally or vertically.
   - Ships must not overlap or go outside the grid.

3. **Types of Ships:** The number and sizes of ships are usually as follows:
   - **Aircraft Carrier:** 5 cells
   - **Battleship:** 4 cells
   - **Submarine:** 3 cells
   - **Patrol Boat:** 2 cells

4. **Gameplay:**
   - The game proceeds in turns.
   - On each turn, a player enters a target coordinate (e.g., B5).
   - If the shot hits a ship, display "Hit." If a ship is completely destroyed, display "Ship Sunk."
   - If the shot misses, display "Miss."

5. **Winning Condition:**
   - The player who sinks all opponent ships first wins the game.

---

## Required Features
1. **Terminal Input and Output:**
   - The game must run in the terminal and accept user input via the console.

2. **Input Validation:**
   - The entered coordinates must be valid (within the grid and not repeated).
   - Ship placement must be validated to prevent overlapping or out-of-bound ships.

3. **Game State Display:**
   - Show the current game state, including targeted cells and sunken ships.

4. **Turn-Based System:**
   - The game should alternate turns between two players or between a player and the computer.

5. **Winner Announcement:**
   - At the end of the game, display the name of the winner.

---

## Suggested Class Structure
To encourage object-oriented design, it is recommended to create the following classes:

1. **`Game`**
   - Manages the overall game flow and turn order.

2. **`Player`**
   - Maintains player information and the game board.

3. **`Board`**
   - Displays and manages the game grid.

4. **`Ship`**
   - Stores information about each ship (size, position, and status).

5. **`Coordinate`**
   - Represents a specific cell on the board.

6. **`Utils`**
   - Contains helper methods for displaying the board and validating input.

---

## Additional Notes
- Write clean and well-documented code.
- Use OOP principles such as encapsulation and inheritance.
- Write necessary tests for critical parts of the program.
- Be creative and consider adding optional features like single-player mode or simple AI.

Good luck and enjoy learning!

