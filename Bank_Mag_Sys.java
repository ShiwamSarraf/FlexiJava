
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) { super(msg); }
}

class Account {
    String accNum, holderName;
    double balance;

    Account(String accNum, String holderName, double balance) {
        this.accNum = accNum;
        this.holderName = holderName;
        this.balance = balance;
    }

    void deposit(double amount) { balance += amount; }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) throw new InsufficientFundsException("Not enough balance!");
        balance -= amount;
    }

    void transfer(Account target, double amount) throws InsufficientFundsException {
        this.withdraw(amount);
        target.deposit(amount);
    }
}

public class Bank_Mag_Sys {
    public static void main(String[] args) {
        Account a1 = new Account("101", "Poshak", 5000);
        Account a2 = new Account("102", "Rahul", 2000);
        
        try {
            a1.transfer(a2, 1000);
            System.out.println("Transfer successful. A1 Balance: " + a1.balance);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
