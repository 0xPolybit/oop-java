package lab.day1;

import java.util.Scanner;

public class GradeCalculator {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your grade: ");
        int score = sc.nextInt();
        char grade;

        if (score >= 90) {
            grade = 'O';
        } else if (score >= 80) {
            grade = 'E';
        } else if (score >= 70) {
            grade = 'A';
        } else if (score >= 60) {
            grade = 'B';
        } else if (score >= 50) {
            grade = 'C';
        } else {
            grade = 'F';
        }

        System.out.println("Your grade is: " + grade);

        sc.close();
    }

}
