abstract class Transport {
    String trackingId;
    String destination;

    Transport(String id, String dest) {
        trackingId = id;
        destination = dest;
    }
    abstract void dispatch();
}

interface GPS {
    void getCoordinates();
}
interface Autonomous {
    void selfNavigate();
}

class DeliveryDrone extends Transport implements GPS, Autonomous {

    DeliveryDrone(String id, String dest) {
        super(id, dest);
    }
    void dispatch() {
        System.out.println("Drone " + trackingId + " Taking Off");
    }
    public void getCoordinates() {
        System.out.println("40.7128° N, 74.0060° W");
    }
    public void selfNavigate() {
        System.out.println("Drone Navigating Automatically");
    }
}

class Truck extends Transport {

    Truck(String id, String dest) {
        super(id, dest);
    }
    void dispatch() {
        System.out.println("Truck " + trackingId + " Leaving Warehouse");
    }
}

class CargoShip extends Transport implements GPS {

    CargoShip(String id, String dest) {
        super(id, dest);
    }
    void dispatch() {
        System.out.println("Ship " + trackingId + " Sailing");
    }
    public void getCoordinates() {
        System.out.println("On ocean route");
    }
}

public class SmartLogistics {
    public static void main(String[] args) {

        Transport t = new DeliveryDrone("D101", "NY");
        t.dispatch();

        GPS g = new DeliveryDrone("D101", "NY");
        g.getCoordinates();

        if (t instanceof GPS) {
            System.out.println("This transport has GPS");
        }

        Transport[] list = {
            new DeliveryDrone("D1", "NY"),
            new Truck("T1", "LA"),
            new CargoShip("S1", "UK")
        };
        for (Transport tr : list) {
            tr.dispatch();
        }
    }
}