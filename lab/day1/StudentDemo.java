package lab.day1;

import java.util.Scanner;

public class StudentDemo {
    
    public static class Student {

        String name;
        int roll;
        String branch;
        byte section;

        public Student (String name, int roll, String branch, byte section) {
            this.name = name;
            this.roll = roll;
            this.branch = branch;
            this.section = section;
        }

        public void displayStudentDetails() {
            System.out.println("Student Details:");
            System.out.println(" - Name: " + name);
            System.out.println(" - Roll Number: " + roll);
            System.out.println(" - Branch: " + branch);
            System.out.println(" - Section: " + branch + "-" + section);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter student branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter student section: ");
        byte section = sc.nextByte();

        Student student = new Student(name, roll, branch, section);
        student.displayStudentDetails();

        sc.close();
    }

}
