package lab.day3;

import java.util.Scanner;

public class Dimensions {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length: ");
        double length = sc.nextDouble();

        System.out.print("Enter the width: ");
        double width = sc.nextDouble();

        System.out.print("Enter the height: ");
        double height = sc.nextDouble();

        System.out.print("Enter the thickness: ");
        double thickness = sc.nextDouble();

        WoodBox woodbox = new WoodBox(length, width, height, thickness);

        System.out.println("For object:");
        System.out.println("Length: " + woodbox.length);
        System.out.println("Width: " + woodbox.width);
        System.out.println("Height: " + woodbox.height);
        System.out.println("Thickness: " + woodbox.thickness);

        sc.close();
    }

}

class Plate {

    double length;
    double width;

    public Plate(double length, double width) {
        this.length = length;
        this.width = width;
    }

}

class Box extends Plate {

    double height;

    public Box(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

}

class WoodBox extends Box {

    double thickness;

    public WoodBox(double length, double width, double height, double thickness) {
        super(length, width, height);
        this.thickness = thickness;
    }
    
}