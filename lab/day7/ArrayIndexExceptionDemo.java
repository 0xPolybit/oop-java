package lab.day7;

import java.util.Scanner;

public class ArrayIndexExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[4];

        try {
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception in thread \"main\" java.lang.ArrayIndexOutOfBoundsException:" + e.getMessage());
        }
        
        sc.close();
    }
}