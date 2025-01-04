import java.util.ArrayList;
import java.util.List;

public class VehicalManager {
    public static void main(String[] args) {
        List<Vehical> vehicles = new ArrayList();
        vehicles.add(new Bicycle("Xe dap", 5000));
        vehicles.add(new Motorcycle("Vario", 15000));
        vehicles.add(new Truck("Xe Tai",30000,200));

        for (Vehical vehical : vehicles) {
            vehical.displayInfo();
            vehical.refuel(500);
            vehical.move(100);
            vehical.displayInfo();
            System.out.println();
        }
    }
}
