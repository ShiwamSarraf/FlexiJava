// Base Class
class Account {
    protected double balance;

    // Constructor
    Account(double balance) {
        this.balance = balance;
    }

    // Method to calculate interest (2%)
    double calculateInterest() {
        return balance * 0.02;
    }
}

// Derived Class
class SavingsAccount extends Account {

    SavingsAccount(double balance) {
        super(balance);
    }

    // Override method (4% + bonus)
    @Override
    double calculateInterest() {
        double interest = balance * 0.04;

        if (balance > 50000) {
            interest += 500; // loyalty bonus
        }

        return interest;
    }
}

// Derived from SavingsAccount
class FixedDeposit extends SavingsAccount {

    FixedDeposit(double balance) {
        super(balance);
    }

    // Override again
    @Override
    double calculateInterest() {
        // Use parent logic + extra 2%
        return super.calculateInterest() + (balance * 0.02);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Test Case 1
        Account acc1 = new SavingsAccount(10000);
        System.out.println("TC1 Output: " + acc1.calculateInterest()); // 400

        // Test Case 2
        Account acc2 = new SavingsAccount(60000);
        System.out.println("TC2 Output: " + acc2.calculateInterest()); // 2900

        // Test Case 3
        Account acc3 = new FixedDeposit(60000);
        System.out.println("TC3 Output: " + acc3.calculateInterest()); // 4100
    }
}