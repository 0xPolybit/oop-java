package lab.day4;

import java.util.Scanner;

abstract class Student {
    int rollNo;
    long regNo;

    void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rollno - ");
        rollNo = sc.nextInt();
        System.out.print("Registration no - ");
        regNo = sc.nextLong();
        sc.close();
    }

    abstract void course();
}

class Kiitian extends Student {
    @Override
    void course() {
        System.out.println("Rollno - " + rollNo);
        System.out.println("Registration no - " + regNo);
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }
}

public class StudentAbstractDemo {
    public static void main(String[] args) {
        Kiitian k = new Kiitian();
        k.getInput();
        k.course();
    }
}
