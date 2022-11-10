package Sudoku;

import static java.sql.Types.NULL;
/**
 * @name Sudoku.Sudoku Solver
 * @brief - You will create a mini Sudoku.Sudoku solver. In the real game of Sudoku.Sudoku, a 9 x 9 grid is used. The numbers 1
 * through 9 must appear in each row, column, and 3x3 sub-grid. In our mini Sudoku.Sudoku, we will not worry
 * about sub-grids. A valid solution is any solution that makes sure the numbers 1 through 9 appear in
 * each row and column without any duplicates. For example, below you will see a solution to a 3 x 3
 * puzzle. The image on the left is the input to the algorithm. The image on the right is the output. Notice
 * there is a 1, 2, and 3 in each row and column. Numbers CAN be repeated across the diagonals (e.g.
 * notice 1-1-1, as you read from top left to bottom right).
 */
public class Sudoku {
    private static final int EMPTY_CELL = NULL;
    public static final int[][] GRID_A = {
            {EMPTY_CELL, 2, EMPTY_CELL},
            {3, 1, EMPTY_CELL},
            {EMPTY_CELL, 3, EMPTY_CELL}
    };
    public static final int[][] GRID_B = {
            {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {EMPTY_CELL, EMPTY_CELL, 1},
            {EMPTY_CELL, 3, EMPTY_CELL}
    };
    /**
     * @brief - This method will take in an incomplete sudoku board and return a finished sudoku board.
     * @param grid
     * @param i
     * @param j
     * @return grid
     */
    public static int[][] solve(int[][] grid, int i, int j) {
        if (i == grid.length) {
            i = 0;
            if (++j == grid[i].length) {
                return grid;
            }
        }

        if (grid[i][j] != EMPTY_CELL) {
            return solve(grid, i + 1, j);
        }

        for (int value = 1; value <= grid.length; value++) {
            if (legal(grid, i, j, value)) {
                grid[i][j] = value;

                if (solve(grid, i + 1, j) != null) {
                    return grid;
                }
            }
        }

        grid[i][j] = EMPTY_CELL;

        return null;
    }
    /**
     * @brief - This method will check to see if the number is legal in the grid and if so, it will return a true.
     * @param grid
     * @param i
     * @param j
     * @param value
     * @return boolean
     */
    public static boolean legal(int[][] grid, int i, int j, int value) {
        for (int k = 0; k < grid.length; k++) {
            if (value == grid[k][j]) {
                return false;
            }
        }

        for (int k = 0; k < grid[i].length; k++) {
            if (value == grid[i][k]) {
                return false;
            }
        }

        return true;
    }
    public static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] GA = solve(GRID_A, 0, 0);
        int[][] GB = solve(GRID_B, 0, 0);

        System.out.println("Grid A:");
        print(GA);
        System.out.println("Grid B:");
        print(GB);
    }
}