package general;

public class Employee {
    protected int empid;
    private String ename;

    public Employee(int empid, String ename) {
        this.empid = empid;
        this.ename = ename;
    }

    public double earnings(double basic) {
        return basic + (0.8 * basic) + (0.15 * basic);
    }
}

// ---

package marketing;

import general.employee;
import java.util.Scanner;

public class Sales extends Employee {
    public Sales(int empid, String ename) {
        super(empid, ename);
    }

    public double tallowance(double totalEarnings) {
        return 0.05 * totalEarnings;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee id and emploee name ");
        int id = sc.nextInt();
        String name = sc.next();
        System.out.print("Enter the basic salary ");
        double basic = sc.nextDouble();

        Sales s = new Sales(id, name);
        double totalEarnings = s.earnings(basic);

        System.out.println("The emp id of the employee is " + s.empid);
        System.out.println("The total earning is " + totalEarnings);
    }
}
