package lab.day2;

import java.util.Scanner;

public class ObjectCounter {

    static class MyClass {

        private static int count = 0;

        public MyClass() {
            count++;
        }

        public static int getCount() {
            return count;
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of objects to create");
        int n = sc.nextInt();
        if (n < 0) n = 0;
        MyClass[] arr = new MyClass[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new MyClass();
        }
        System.out.println("no of objects=" + MyClass.getCount());
        sc.close();
    }

}
