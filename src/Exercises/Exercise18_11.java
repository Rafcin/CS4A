package Exercises;

import java.util.Scanner;

public class Exercise18_11 {
    public static long sumOfDigitsInNumber(long n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDigitsInNumber(n / 10);
    }
    //Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        long number = scanner.nextLong();
        System.out.println("The sum of the digits in " + number + " is " + sumOfDigitsInNumber(number));
    }
}
