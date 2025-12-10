package practice;

import java.util.Scanner;

public class StudentDemo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your ID: ");
        int roll = sc.nextInt();

        sc.close();

        Student student = new Student(name, roll);
        student.printStudentDetails();
    }

}
