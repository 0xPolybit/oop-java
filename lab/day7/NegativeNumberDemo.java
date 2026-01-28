package lab.day7;

import java.util.Scanner;

public class NegativeNumberDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        try {
            ProcessInput(n);
        } catch (NegativeNumberException e) {
            System.out.println("Caught the exception");
            System.out.println(" Exception occurred:  " + e);
        } finally {
            sc.close();
        }
    }

    static void ProcessInput(int number) throws NegativeNumberException {
        if (number < 0) throw new NegativeNumberException("number should be positive");
        System.out.println("Double value:  " + (number * 2));
    }
}

class NegativeNumberException extends Exception {
    NegativeNumberException(String message) {
        super(message);
    }
}