public class Motorcycle extends AbstractVehicle{
    private double fuelLevel;
    public Motorcycle(String name, double baseMaintenanceCost){
        super(name,baseMaintenanceCost);
    }

    @Override
    public double calculateFuelCost(int distance) {
        return distance;
    }


    @Override
    public void displayInfo() {

    }

    @Override
    public void move(int distance) {
        double fuelNeeded = distance *0.1;

    }

    @Override
    public double calculateMaintanenceCost() {
        return baseMaintenanceCost+ calculateFuelCost(mileage);
    }
    public void refuel(double amount){
            this.fuelLevel += amount;
            System.out.println(name + " da duoc nap them "+ amount + " lit nhien lieu");
        }
    public void dislayInfo(){
        System.out.println("Phuong tien "+ name + ", So km da di chuyen: " + mileage +"km, chi phi bao tri: "+ calculateMaintanenceCost()+ "VND, nhien lieu con lai: "+ fuelLevel);
    }
}
