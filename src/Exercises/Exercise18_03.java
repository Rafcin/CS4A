package Exercises;

import java.util.Scanner;

public class Exercise18_03 {
    //Greatest Common Divisor
    public static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }
    //Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("The GCD of " + firstNumber + " and " + secondNumber + " is " + gcd(firstNumber, secondNumber));
    }
}
