package lab.day2;

import java.util.Scanner;

public class RectangleAreaOverload {
    double length;
    double breadth;

    // default constructor initializes members to zero
    public RectangleAreaOverload() {
        this.length = 0;
        this.breadth = 0;
    }

    // parameterized constructor
    public RectangleAreaOverload(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double area() {
        return this.length * this.breadth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and breadth");
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number for length:");
            sc.next();
        }
        double l = sc.nextDouble();
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number for breadth:");
            sc.next();
        }
        double b = sc.nextDouble();

        RectangleAreaOverload rect = new RectangleAreaOverload(l, b);
        System.out.println("Area of rectangle: " + rect.area());
        sc.close();
    }
}
