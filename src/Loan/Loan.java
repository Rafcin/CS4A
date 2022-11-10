package Loan;

import java.util.Scanner;

public class Loan {
    public static double positiveInputHelper(String msg, String error, Scanner scanner) {
        double result;
        System.out.print(msg);
        while(!scanner.hasNextDouble() || (result = scanner.nextDouble()) <= -0.0) {
            if(scanner.nextDouble() == 0) {
                System.out.println("THANK YOU FOR USING THE MORTGAGE CALCULATOR!!");
                System.exit(0);
            }
            System.out.println(error);
            scanner.nextLine();
        }
        scanner.nextLine();
        return result;
    }

    public static double cmp(double l, double t, double r) {
        double mr = (r / 100.0) / 12;
        double mp = (mr * l)/(1-Math.pow((1 + mr), - t));
        return mp;
    }

    public static void cal() {
        Scanner input = new Scanner(System.in);
        double loan, ir, years, months;
        //Everytime I write encapsulated code I feel better knowing I didn't write shit.
        loan = positiveInputHelper("Please enter a positive integer for the loan amount:", "RETRY: Please enter a positive integer for the loan amount:", input);
        ir = positiveInputHelper("Please enter a positive number for the annual interest rate:", "RETRY: Please enter a positive number for the annual interest rate:", input);
        years = positiveInputHelper("Please enter a positive integer for the term in years:", "RETRY: Please enter a positive integer for the term in years:", input);
        months = years * 12.0;
        //cmp(loan, months, ir)
        double mp = cmp(loan, months, ir);
        double tmp = mp * months;
        double tip = tmp - loan;
        System.out.println("For a loan with these characteristics:");
        System.out.println("\t" + "$" + loan);
        System.out.println("\t" + ir + " annual interest rate");
        System.out.println("\t" + years + " year term");
        System.out.println();
        System.out.println("The Monthly Payment = $" + mp);
        System.out.println("The Total Amount Paid = $" + tmp);
        System.out.println("The Total Interest Paid = $" + tip);
        // = $911363.20 The Total Interest Paid
        System.out.println("\n");
    }

    public static void main(String[] args) {
        while(true) {
            cal();
        }
    }
}
