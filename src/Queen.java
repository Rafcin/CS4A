import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen {
    private static final char BLANK = '-';
    private static final char QUEEN = '♕';
    private static final int SIZE = 5;

    private List<String> conversion(char[][] board) {
        List<String> nb = new ArrayList<>();
        for (char[] row: board) nb.add(new String(row));
        return nb;
    }
    private boolean validate(int cols, int col, int pd, int cpd, int nd, int cnd) {
        if ((cols & (1 << col)) != 0 || (pd & (1 << cpd)) != 0 || (nd & (1 << cnd)) != 0) { return true; } else { return false; }
    }
    private void dfs(List<List<String>> result, char[][] board, int row, int cols, int pd, int nd, int n) {
        //Have we reached the end?
        //If true board is now valid, and we can go to sleep and stop looking at code.
        if (row == n) { result.add(conversion(board)); return; }
        /**
         * Loop through each col
         * If we can't add the Queen to the current col @ this pos, we skip this col val.
         * If we can add the Queen to the current col @ this pos, we add it and perform bit manip.
         * Undo try other combs
         */
        //https://codereview.stackexchange.com/questions/75517/n-queens-brute-force-bit-by-bit
        //https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
        for (int col = 0; col < n; col++) {
            //Pos & Neg diag
            int cpd = row - col + n;
            int cnd = row + col;

            //You take too much of my screen up.
            //Now you don't.
            if (validate(cols, col, pd, cpd, nd, cnd)) continue;

            //Bit manipulation
            //Do
            board[row][col] = QUEEN;
            cols |= (1 << col);
            pd |= (1 << cpd);
            nd |= (1 << cnd);
            //DFS
            dfs(result, board, row + 1, cols, pd, nd, n);
            //Undo
            board[row][col] = BLANK;
            cols ^= (1 << col);
            pd ^= (1 << cpd);
            nd ^= (1 << cnd);
        }
    }
    public List<List<String>> solve(int n) {
        List<List<String>> result = new ArrayList<>();
        //Raf it's Raf from last night. Arraylist bad. That is all.
        char[][] board = new char[n][n];
        for (char[] row: board) Arrays.fill(row, BLANK);
        dfs(result, board, 0, 0, 0, 0, n);
        return result;
    }

    public static void main(String[] args) {
        Queen q = new Queen();
        List<List<String>> results = q.solve(SIZE);
        //Display possible solutions
        for(List<String> result : results) {
            System.out.println("[Solution]");
            for(String row : result) {
                System.out.println(row);
            }
        }
        System.out.println("Generated " + results.size() + " solutions.");
    }
}
