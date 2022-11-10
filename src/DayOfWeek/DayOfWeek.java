package DayOfWeek;

import java.util.Scanner;

/**
 * DayOfWeek.DayOfWeek takes an input(s) string in the order MM DD YYYY deliminated by spaces and returns the day of the week for that date.
 * This calss does not use any Java utility methods excluding Scanner for the purpose of the exercise.
 * @author Rafael Szuminski
 * @version 1.0
 * @date 2022-09-27
 */

//My first plan was to write a utility class called Date that would replicate how Date works in Java. However, I soon realized that would take forever.
public class DayOfWeek {
    public static void main(String[] args) {
        System.out.println(
                "Welcome to the Day Of Week calculator. This awesome program will tell you\n" +
                        "what day of the week you were born on!\n" +
                        "The program will allow you to find the day of the week for multiple dates.\n" +
                        "When you want exit the program enter a 0 for the month, day, or year.\n"
        );
        while(true) {
            Scanner scanner = new Scanner(System.in);
            //Prompt user to input MM/DD/YYYY as a single string deliminated by spaces.
            String date;
            do {
                System.out.println("Enter a date in the format MM DD YYYY: ");
                date = scanner.nextLine();
                if(date.matches("0 0 0")) {
                    System.out.println("THANK YOU FOR USING THE DAY OF WEEK CALCULATOR!");
                    System.exit(0);
                }
                if(!date.matches("^[0-9]{1,2}\\ (0[1-9]|1\\d|2\\d|3[01])\\ (19|20)\\d{2}$")) {
                    System.out.println("Invalid date format. Please try again.");
                }
            }while(!date.matches("^[0-9]{1,2}\\ (0[1-9]|1\\d|2\\d|3[01])\\ (19|20)\\d{2}$"));
            //Split the string into an array of strings.
            String[] dateArray = date.split(" ");
            //Convert the strings to integers.
            int month = Integer.parseInt(dateArray[0]);
            int day = Integer.parseInt(dateArray[1]);
            int year = Integer.parseInt(dateArray[2]);

            //Check to see if the month is valid.
            if(!(1 <= month && month <= 12)) {
                System.out.println("The month entered is not valid.");
                continue;
            }
            //Check to see if the day is valid.
            if(!(1 <= day && day <= 31)) {
                System.out.println("The day entered is not valid.");
                continue;
            }
            //Check to see if the year is valid.
            if(!(0 <= year)) {
                System.out.println("The year entered is not valid.");
                continue;
            }

            //Check to see if the date is invalid.
            if(!(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
                if(day == 31) {
                    System.out.println("The date entered is not valid.");
                    continue;
                }
            }
            if(month == 2) {
                if(year % 4 == 0) {
                    if(day > 29) {
                        System.out.println("The date entered is not valid.");
                        continue;
                    }
                } else {
                    if(day > 28) {
                        System.out.println("The date entered is not valid.");
                        continue;
                    }
                }
            }

            //Calculate the number of days since January 1, 1970.
            int days = 0;
            for(int i = 1970; i < year; i++) {
                if(i % 4 == 0) {
                    days += 366;
                } else {
                    days += 365;
                }
            }

            for(int i = 1; i < month; i++) {
                switch(i) {
                    case 1: days += 31; break;
                    case 2: if(year % 4 == 0) days += 29; else days += 28; break;
                    case 3: days += 31; break;
                    case 4: days += 30; break;
                    case 5: days += 31; break;
                    case 6: days += 30; break;
                    case 7: days += 31; break;
                    case 8: days += 31; break;
                    case 9: days += 30; break;
                    case 10: days += 31; break;
                    case 11: days += 30; break;
                }
            }

            days += day - 1;

            //Determine the day of the week.
            int dayOfWeek = (days + 4) % 7;

            switch(dayOfWeek) {
                case 1: System.out.println("The date you entered was a Monday"); break;
                case 2: System.out.println("The date you entered was a Tuesday"); break;
                case 3: System.out.println("The date you entered was a Wednesday"); break;
                case 4: System.out.println("The date you entered was a Thursday"); break;
                case 5: System.out.println("The date you entered was a Friday"); break;
                case 6: System.out.println("The date you entered was a Saturday"); break;
                case 0: System.out.println("The date you entered was a Sunday"); break;
            }
        }

    }
}