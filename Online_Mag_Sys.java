import java.util.ArrayList;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {
    ArrayList<Product> items = new ArrayList<>();

    void addProduct(Product p) { items.add(p); }

    void removeProduct(String name) {
        items.removeIf(p -> p.name.equalsIgnoreCase(name));
    }

    double calculateTotalCost() {
        double total = 0;
        for (Product p : items) total += p.price;
        return total;
    }

    void displayCart() {
        for (Product p : items) System.out.println(p.name + ": $" + p.price);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
}

public class Online_Mag_Sys {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 1200));
        cart.addProduct(new Product("Mouse", 25));
        cart.displayCart();
        
        System.out.println("\nRemoving Mouse...");
        cart.removeProduct("Mouse");
        cart.displayCart();
    }
    
}
