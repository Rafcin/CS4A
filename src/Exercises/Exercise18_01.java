package Exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise18_01 {
    //Factorial
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
    //Main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer of any size: ");
        String number = input.nextLine();
        System.out.println("The factorial" + number + " is " + factorial(new BigInteger(number)));

    }
}
