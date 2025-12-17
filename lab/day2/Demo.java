package lab.day2;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length, width and height");
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number for length:");
            sc.next();
        }
        double length = sc.nextDouble();
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number for width:");
            sc.next();
        }
        double width = sc.nextDouble();
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number for height:");
            sc.next();
        }
        double height = sc.nextDouble();

        Box box = new Box(length, width, height);
        System.out.println("Volume: " + box.volume());
        sc.close();
    }
}

class Box {
    double length;
    double width;
    double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double volume() {
        return length * width * height;
    }
}
