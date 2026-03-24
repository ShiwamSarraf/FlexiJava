abstract class Device {
    String brand;
    
    Device(String brand) {
        this.brand = brand;
    }
    abstract void turnOn();
}
interface RemoteControllable {
    void connectToWifi();
}
interface PowerSaving {
    int getEnergyRating();
}

class SmartTV extends Device implements RemoteControllable, PowerSaving {
    SmartTV(String brand) {
        super(brand);
    }
    void turnOn() {
        System.out.println(brand + " TV is booting up...");
    }
    public void connectToWifi() {
        System.out.println("Connecting to Home_5G...");
    }
    public int getEnergyRating() {
        return 5;
    }
}

class ElectricKettle extends Device {
    ElectricKettle(String brand) {
        super(brand);
    }
    void turnOn() {
        System.out.println(brand + " Kettle is heating water...");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Device d = new SmartTV("Sony");
        d.turnOn();
        RemoteControllable r = new SmartTV("LG");
        r.connectToWifi();


    }
}