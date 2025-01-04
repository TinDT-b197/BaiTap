public class Bicycle extends AbstractVehicle {
    private static final int MAINTENANCE_INTERVAL = 100;

    public Bicycle(String name, double baseMaintenanceCost) {
        super(name, baseMaintenanceCost);
    }

    @Override
    public double calculateFuelCost(int distance) {
        return 0;
    }

    @Override
    public double calculateMaintenanceCost() {
        return 0;
    }

    @Override
    public void displayInfo() {

    }

    @Override
    public double calculateMaintanenceCost() {
        return baseMaintenanceCost + 50000;
    }

    @Override
    public void move(int distance) {
        this.mileage+=distance;
    }

    @Override
    public void refuel(double amount) {

    }

    private void checkMaintenance() {
        if (mileage % MAINTENANCE_INTERVAL == 0) {
            System.out.println(name + " cần kiểm tra bảo trì định kỳ.");
        }
    }
    public void dislayInfo(){
        System.out.println("Phuong tien "+ name + ", So km da di chuyen: " + mileage +"km, chi phi bao tri: "+ calculateMaintanenceCost()+ "VND");
    }
}