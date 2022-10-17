package Exercises;

import java.util.Scanner;

public class Exercise18_21 {
    public static int toBinary(int n) {
        if (n == 0) return 0;
        return n % 2 + 10 * toBinary(n / 2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a decimal integer: ");
        int number = scanner.nextInt();
        System.out.println(number + " decimal is binary " + toBinary(number));
    }
}
