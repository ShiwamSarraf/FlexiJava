abstract class Payment {
    private String transactionId;
    private double amount;

    Payment(String id, double amt) {
        transactionId = id;
        amount = amt;
    }
    public double getAmount() {
        return amount;
    }
    abstract double processPayment();
}

class CreditCardPayment extends Payment {
    CreditCardPayment(String id, double amt) {
        super(id, amt);
    }
    double processPayment() {
        return getAmount() * 1.02;
    }
}

class UPIPayment extends Payment {
    UPIPayment(String id, double amt) {
        super(id, amt);
    }
    double processPayment() {
        return getAmount();
    }
}


public class smartpayment {
    public static void main(String[] args) {

        Payment p1 = new CreditCardPayment("T1", 1000);
        Payment p2 = new UPIPayment("T2", 1000);

        System.out.println(p1.processPayment());
        System.out.println(p2.processPayment());

        Payment[] arr = {p1, p2};
        double total = 0;

        for (Payment p : arr) {
            total += p.processPayment();
        }

        System.out.println("Total: " + total);
    }
}