package Exercises;

import java.util.Scanner;

public class Exercise08_25 {

    public static double sum(double[][] m, int c) {
        double s = 0;
        for (int r = 0; r < m.length; r++) s += m[r][c];
        return s;
    }
    public static boolean isMatrix(double[][] m) {
        int mc = 0;
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) if (m[r][c] < 0.0) return false;
            if (sum(m, mc) != 1.0) return false;
            mc++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] m = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix row by row:");
        for (int r = 0; r < m.length; r++)
            for (int c = 0; c < m[r].length; c++)
                m[r][c] = scanner.nextDouble();
        if (isMatrix(m)) System.out.println("It is a Markov Matrix"); else System.out.println("It is not a Markov Matrix");

        scanner.close();
    }
}
