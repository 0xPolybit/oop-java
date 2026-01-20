package lab.day5;

import java.util.Scanner;

interface Salary {
    double earnings(double basic);
    double deductions(double basic);
    double bonus(double basic);
}

abstract class Manager implements Salary {
    public double earnings(double basic) {
        return basic + (0.8 * basic) + (0.15 * basic);
    }

    public double deductions(double basic) {
        return 0.12 * basic;
    }
}

public class Substaff extends Manager {
    public double bonus(double basic) {
        return 0.5 * basic;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basic = sc.nextDouble();

        Substaff obj = new Substaff();
        System.out.println("Earnings - " + (int)obj.earnings(basic));
        System.out.println("Deduction - " + (int)obj.deductions(basic));
        System.out.println("Bonus - " + (int)obj.bonus(basic));
        
        sc.close();
    }
}
