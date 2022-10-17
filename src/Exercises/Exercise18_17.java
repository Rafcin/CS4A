package Exercises;

import java.util.Scanner;

public class Exercise18_17 {
    public static int numberOfOccurences(String str, String target) {
        if (str.length() < target.length()) return 0;
        if (str.substring(0, target.length()).equals(target)) return 1 + numberOfOccurences(str.substring(target.length()), target);
        return numberOfOccurences(str.substring(1), target);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        System.out.println("Enter a character: ");
        String targ = scanner.nextLine();
        System.out.println("The number of letters in the string is " + numberOfOccurences(str, targ));
    }
}
