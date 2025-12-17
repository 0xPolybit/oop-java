package lab.day2;

import java.util.Scanner;

public class StudentList {
    static class Student {
        int roll;
        String name;
        double cgpa;

        Student(int roll, String name, double cgpa) {
            this.roll = roll;
            this.name = name;
            this.cgpa = cgpa;
        }

        @Override
        public String toString() {
            return "Roll: " + roll + ", Name: " + name + ", CGPA: " + cgpa;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students (n)");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("No students to process.");
            sc.close();
            return;
        }

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Roll No, Name and cgpa for student " + (i + 1));
            int roll = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            students[i] = new Student(roll, name, cgpa);
        }

        System.out.println("\nStudent details:");
        for (Student s : students) {
            System.out.println(s);
        }

        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (students[i].cgpa < students[minIdx].cgpa) {
                minIdx = i;
            }
        }

        System.out.println("\nStudent with lowest cgpa: " + students[minIdx].name);
        sc.close();
    }
}
