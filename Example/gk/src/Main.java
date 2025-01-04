import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehical> vehicles = new ArrayList<>();

        vehicles.add(new Bicycle("Xe Đạp", 100000));
        vehicles.add(new Motorcycle("Xe Máy", 200000));
        vehicles.add(new Truck("Xe Tải", 500000));

        for (Vehical vehicle : vehicles) {
            vehicle.displayInfo();
            vehicle.refuel(500);
            vehicle.move(100);
            vehicle.displayInfo();
            System.out.println();
        }
    }
}