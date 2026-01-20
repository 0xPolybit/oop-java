package lab.day5;

import java.util.Scanner;

interface Employee {
    void getDetails();
}

interface Manager extends Employee {
    void getDeptDetails();
}

public class Head implements Manager {
    String empid;
    String ename;
    String deptid;
    String deptname;

    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee id - ");
        empid = sc.nextLine();
        System.out.print("Enter employee name - ");
        ename = sc.nextLine();
        sc.close();
    }

    public void getDeptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department id - ");
        deptid = sc.nextLine();
        System.out.print("Enter department name -");
        deptname = sc.nextLine();
        sc.close();
    }

    public void display() {
        System.out.println("Employee id - " + empid);
        System.out.println("Employee name - " + ename);
        System.out.println("Department id - " + deptid);
        System.out.println("Department name -" + deptname);
    }

    public static void main(String[] args) {
        Head h = new Head();
        h.getDetails();
        h.getDeptDetails();
        h.display();
    }
}
