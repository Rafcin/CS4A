package Exercises;

import java.util.Scanner;

public class Exercise08_13 {
    public static int[] find(double[][] m) {
        int[] lg = { 0, 0 };
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                if (m[r][c] > m[lg[0]][lg[1]]) {
                    lg[0] = r;
                    lg[1] = c;
                }
            }
        }
        return lg;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the array:");
        final int r = scanner.nextInt();
        final int c = scanner.nextInt();

        double[][] m = new double[r][c];
        System.out.print("Enter the array:");

        for (int r_ = 0; r_ < r; r_++)
            for (int c_ = 0; c_ < c; c_++)
                m[r_][c_] = scanner.nextDouble();

        int[] result = find(m);

        System.out.println("The location of the largest element is at (" + result[0] + ", " + result[1] + ")");
        scanner.close();
    }
}
