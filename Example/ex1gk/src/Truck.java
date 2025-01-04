public class Truck extends AbstractVehicle{
    private double fuelLevel;
    private double costweight;
    public Truck(String name, double baseMaintenanceCost,double costweight){
        super(name, baseMaintenanceCost);
        this.costweight = costweight;
    }

    @Override
    public double calculateFuelCost() {
        return 0.1*costweight+mileage*0.1;
    }

    @Override
    public double calculateMaintenanceCost() {
        return baseMaintenanceCost+ calculateFuelCost() +500;
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public void refuel(double amount) {
        fuelLevel += amount;
    }

    @Override
    public void move(int distance) {
        double fuelNeeded = distance*0.5;
        if(fuelNeeded<fuelLevel){
            mileage+=distance;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: "+ name+ " Mileage: "+mileage+ " Maintenance Cost: "+calculateMaintenanceCost());
    }
}