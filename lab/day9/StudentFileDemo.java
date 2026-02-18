package lab.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentFileDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the name of the file to write student details: ");
        String fileName = sc.nextLine();

        FileWriter fw = new FileWriter(fileName);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Subject: ");
            String subject = sc.nextLine();
            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            fw.write(rollNo + "," + name + "," + subject + "," + marks + "\n");
        }

        fw.close();
        System.out.println("Student details written to file: " + fileName);

        System.out.println("\nReading student details from file: " + fileName);
        System.out.println("RollNo\tName\tSubject\tMarks");

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            System.out.println(parts[0] + "\t" + parts[1] + "\t" + parts[2] + "\t" + parts[3]);
        }
        br.close();

        sc.close();
    }
}
