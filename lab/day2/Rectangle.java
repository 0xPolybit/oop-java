package lab.day2;

import java.util.Scanner;

public class Rectangle {
    double length;
    double breadth;
    double area;
    double perimeter;

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and breadth");
        this.length = sc.nextDouble();
        this.breadth = sc.nextDouble();
        sc.close();
    }

    public void calculate() {
        this.area = this.length * this.breadth;
        this.perimeter = 2 * (this.length + this.breadth);
    }

    public void display() {
        System.out.println("Area of Rectangle: " + this.area);
        System.out.println("Perimeter of Rectangle: " + this.perimeter);
    }
}

class RectangleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and breadth");

        Rectangle rect = new Rectangle();
        rect.read();
        rect.calculate();
        rect.display();
        
        sc.close();
    }
}
