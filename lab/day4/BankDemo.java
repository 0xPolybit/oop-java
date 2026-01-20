package lab.day4;

import java.util.Scanner;

class Account {
    static int counter = 1000;
    int accountNo;
    String accountType;
    String name;
    double balance;
    int lastDepositDay, lastDepositMonth, lastDepositYear;

    Account(String accountType, String name, double balance, int d, int m, int y) {
        this.accountNo = ++counter;
        this.accountType = accountType;
        this.name = name;
        this.balance = balance;
        this.lastDepositDay = d;
        this.lastDepositMonth = m;
        this.lastDepositYear = y;
    }

    void checkBalance() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Name: " + name);
        System.out.println("Type: " + accountType);
        System.out.println("Balance: Rs " + balance);
    }

    void deposit(double amount, int d, int m, int y) {
        balance += amount;
        lastDepositDay = d;
        lastDepositMonth = m;
        lastDepositYear = y;
        System.out.println("Deposited: Rs " + amount);
        System.out.println("New Balance: Rs " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
            System.out.println("New Balance: Rs " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class StandardAccount extends Account {
    StandardAccount(String name, double balance, int d, int m, int y) {
        super("Standard", name, balance, d, m, y);
    }

    @Override
    void withdraw(double amount) {
        if (amount > 500000) {
            System.out.println("Withdrawal limit exceeded (Max 5 Lakh for Standard).");
        } else if (amount > 100000) {
            double penalty = amount * 0.0005;
            if (amount + penalty <= balance) {
                balance -= (amount + penalty);
                System.out.println("Withdrawn: Rs " + amount);
                System.out.println("  Penalty (0.05%): Rs " + penalty);
                System.out.println("New Balance: Rs " + balance);
            } else {
                System.out.println("Insufficient balance to cover withdrawal and penalty.");
            }
        } else {
            super.withdraw(amount);
        }
    }
}

class PremiumAccount extends Account {
    PremiumAccount(String name, double balance, int d, int m, int y) {
        super("Premium", name, balance, d, m, y);
    }

    @Override
    void withdraw(double amount) {
        if (amount > 1000000) {
            System.out.println("Withdrawal limit exceeded (Max 10 Lakh for Premium).");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
            System.out.println("New Balance: Rs " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Balance: ");
        double bal = sc.nextDouble();
        System.out.print("Enter Date (Day Month Year): ");
        int d = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();
        System.out.print("Select Type (1.Standard 2.Premium): ");
        int type = sc.nextInt();
        Account acc;
        if (type == 1) acc = new StandardAccount(name, bal, d, m, y);
        else acc = new PremiumAccount(name, bal, d, m, y);
        acc.checkBalance();
        System.out.print("Enter Deposit Amount: ");
        double dep = sc.nextDouble();
        System.out.print("Enter Deposit Date (Day Month Year): ");
        d = sc.nextInt();
        m = sc.nextInt();
        y = sc.nextInt();
        acc.deposit(dep, d, m, y);
        System.out.print("Enter Withdrawal Amount: ");
        double with = sc.nextDouble();
        acc.withdraw(with);
        acc.checkBalance();
        sc.close();
    }
}
