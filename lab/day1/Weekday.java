package lab.day1;

import java.util.Scanner;

public class Weekday {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the current day of December 2025: ");
        int day = sc.nextInt();
        String weekday;

        switch (day % 7) {
            case 0:
                weekday = "Sunday";
                break;
            case 1:
                weekday = "Monday";
                break;
            case 2:
                weekday = "Tuesday";
                break;
            case 3:
                weekday = "Wednesday";
                break;
            case 4:
                weekday = "Thursday";
                break;
            case 5:
                weekday = "Friday";
                break;
            case 6:
                weekday = "Saturday";
                break;
            default:
                weekday = "Invalid??";
        }

        System.out.println("The current weekday is: " + weekday);

        sc.close();
    }

}
