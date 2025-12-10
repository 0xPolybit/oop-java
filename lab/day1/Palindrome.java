package lab.day1;

import java.util.Scanner;

public class Palindrome {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        String number = sc.next();

        sc.close();

        int i = 0;
        while (i <= number.length()/2) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
                System.out.println("The given number is NOT a palindrome.");
                return;
            }
        }

        System.out.println("The given number is a palindrome.");
    }

}
