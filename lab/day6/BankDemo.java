package lab.day6;

class Bank {
    String bankName = "Global Bank";

    static class InterestCalculator {
        static double calculateSI(double principal, double rate, double time) {
            return (principal * rate * time) / 100;
        }

        void accessCheck() {
            Bank b = new Bank();
            System.out.println("Non-static member accessed through object: " + b.bankName);
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {
        double si = Bank.InterestCalculator.calculateSI(1000, 5, 2);
        System.out.println("Simple Interest: " + si);

        Bank.InterestCalculator ic = new Bank.InterestCalculator();
        ic.accessCheck();
    }
}
