public class Bicycle extends AbstractVehicle{
    public Bicycle(String name, double baseMaintenanceCost){
        super(name, baseMaintenanceCost);
    }

    @Override
    public String getType() {
        return "Bicycle";
    }
    @Override
    public double calculateFuelCost() {
        return 0;
    }

    @Override
    public double calculateMaintenanceCost() {
        return baseMaintenanceCost +10;
    }

    @Override
    public void move(int distance) {
        mileage+=distance;
    }

    @Override
    public void displayInfo(){
        System.out.println("Name: "+name+ " Mileage: "+mileage+" Maintenance Cost: "+ calculateMaintenanceCost());
    }

    @Override
    public void refuel(double amount) {}
}
