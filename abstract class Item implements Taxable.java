import java.util.*;

// Interface
interface Taxable {
    double calculateTax();
}

// Abstract class
abstract class Item implements Taxable {
    String itemID;
    String name;
    double basePrice;

    Item(String itemID, String name, double basePrice) {
        this.itemID = itemID;
        this.name = name;
        this.basePrice = basePrice;
    }

    abstract void display();
}

// Perishable Item
class PerishableItem extends Item {
    String expiryDate;

    PerishableItem(String itemID, String name, double basePrice, String expiryDate) {
        super(itemID, name, basePrice);
        this.expiryDate = expiryDate;
    }

    public double calculateTax() {
        return basePrice * 0.05;
    }

    void display() {
        System.out.println("ID: " + itemID +
                " | Name: " + name +
                " | Price: " + basePrice +
                " | Expiry: " + expiryDate);
    }
}

// Electronic Item
class ElectronicItem extends Item {
    int warrantyPeriod;

    ElectronicItem(String itemID, String name, double basePrice, int warrantyPeriod) {
        super(itemID, name, basePrice);
        this.warrantyPeriod = warrantyPeriod;
    }

    public double calculateTax() {
        return basePrice * 0.15;
    }

    void display() {
        System.out.println("ID: " + itemID +
                " | Name: " + name +
                " | Price: " + basePrice +
                " | Warranty: " + warrantyPeriod + " months");
    }
}

// Main Program
public class SmartWarehouse {
    static HashMap<String, Item> inventory = new HashMap<>();

    public static void addItem(Item item) {
        inventory.put(item.itemID, item);
    }

    public static void displayItems() {
        for (Item item : inventory.values()) {
            item.display();
        }
    }

    public static void searchItem(String id) {
        if (inventory.containsKey(id)) {
            inventory.get(id).display();
        } else {
            System.out.println("Item not found.");
        }
    }

    public static void totalInventoryValue() {
        double total = 0;

        for (Item item : inventory.values()) {
            total += item.basePrice + item.calculateTax();
        }

        System.out.println("Total Inventory Value (Incl. Tax): $" + total);
    }

    public static void sortByPrice() {
        ArrayList<Item> list = new ArrayList<>(inventory.values());

        list.sort((a, b) -> Double.compare(a.basePrice, b.basePrice));

        System.out.println("Items sorted by price:");
        for (Item item : list) {
            item.display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Perishable Item");
            System.out.println("2.Add Electronic Item");
            System.out.println("3.Display Items");
            System.out.println("4.Search Item");
            System.out.println("5.Total Inventory Value");
            System.out.println("6.Sort By Price");
            System.out.println("7.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String pid = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double pprice = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Expiry Date: ");
                    String expiry = sc.nextLine();

                    addItem(new PerishableItem(pid, pname, pprice, expiry));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    String eid = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String ename = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double eprice = sc.nextDouble();

                    System.out.print("Enter Warranty (months): ");
                    int warranty = sc.nextInt();
                    sc.nextLine();

                    addItem(new ElectronicItem(eid, ename, eprice, warranty));
                    break;

                case 3:
                    displayItems();
                    break;

                case 4:
                    System.out.print("Enter Item ID: ");
                    String search = sc.nextLine();
                    searchItem(search);
                    break;

                case 5:
                    totalInventoryValue();
                    break;

                case 6:
                    sortByPrice();
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}