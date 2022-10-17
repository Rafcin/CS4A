package Exercises;

import java.util.Scanner;

public class Exercise08_05 {
    public static double[][] cm(int r, int c) {
        Scanner scanner = new Scanner(System.in);
        double[][] m = new double[r][c];
        for(int r_ = 0; r_ < r; r_++) {
            for(int c_ = 0; c_ < c; c_++) {
                m[r_][c_] = scanner.nextDouble();
            }
        }
        return m;
    }

    public static double[][] am(double[][] a, double[][] b) {
        if(a.length == 0) return null;
        if(a.length != b.length) return null;
        for(int i = 0; i < a.length; i++) {
            if(a[0].length != b[i].length) return null;
        }
        double[][] sm = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                sm[i][j] = a[i][j] + b[i][j];
            }
        }
        return sm;
    }

    public static void printm(double[][] m1, double[][] m2, double[][] sm) {
        for(int i = 0; i < m1.length; i++) {
            for(int j = 0; j < m1[0].length; j++) {
                System.out.printf("%4.1f", m1[i][j]);
            }
            System.out.print(i == m1.length / 2 ? "  +   " : "      ");
            for(int j = 0; j < m2[0].length; j++) {
                System.out.printf("%4.1f", m2[i][j]);
            }
            System.out.print(i == m1.length / 2 ? "  =   " : "      ");
            for(int j = 0; j < sm[0].length; j++) {
                System.out.printf("%4.1f", sm[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter matrix1:");
        double[][] m1 = cm(3, 3);
        System.out.println("Enter matrix2:");
        double[][] m2 = cm(3, 3);
        double[][] sm = am(m1, m2);
        System.out.println("The addition of the matrices is");
        printm(m1, m2, sm);
    }
}