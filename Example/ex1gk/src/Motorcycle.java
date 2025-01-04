public class Motorcycle extends AbstractVehicle{
    private double FuelLevel;
    public Motorcycle(String name, double baseMaintenanceCost){
        super(name, baseMaintenanceCost);
    }

    @Override
    public double calculateFuelCost() {
        return mileage*0.1;
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }

    @Override
    public double calculateMaintenanceCost() {
        return baseMaintenanceCost + calculateFuelCost()+ 500;
    }

    @Override
    public void refuel(double amount) {
        FuelLevel += amount;
    }

    @Override
    public void move(int distance) {
        double FuelNeeded = distance*0.1;
        if( FuelNeeded < FuelLevel){
            mileage +=distance;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name +" Mileage: "+ mileage+ " Maintenance Cost: "+calculateMaintenanceCost());
    }
}
