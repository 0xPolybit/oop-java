package lab.day3;

import java.util.Scanner;

public class Manufacture {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length: ");
        double length = sc.nextDouble();
        System.out.print("Enter the breadth: ");
        double breadth = sc.nextDouble();
        System.out.print("Enter the height: ");
        double height = sc.nextDouble();

        Cube3D cube = new Cube3D(length, breadth, height);
        System.out.println("Cost of manufacturing: " + cube.cost());

        sc.close();
    }
    
}

class Box2D {

    double length;
    double breadth;

    public Box2D(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double cost() {
        return 40 * this.length * this.breadth;
    }

}
 class Cube3D extends Box2D {
    
    double height;
    
    public Cube3D(double length, double breadth, double height) {
        super(length, breadth);
        this.height = height;
    }

    @Override
    public double cost() {
        return 60 * super.length * super.breadth * this.height;
    }

 }