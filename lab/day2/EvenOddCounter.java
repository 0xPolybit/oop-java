package lab.day2;

public class EvenOddCounter {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int even = 0, odd = 0;
        System.out.println("Enter 10 numbers from keyboard: ");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter an integer: ");
            int n = sc.nextInt();
            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Number of even numbers: " + even);
        System.out.println("Number of odd numbers: " + odd);
        sc.close();
    }
}
