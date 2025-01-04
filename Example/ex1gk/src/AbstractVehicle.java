public abstract class AbstractVehicle implements Vehical {
    protected String name;
    protected double baseMaintenanceCost;
    protected int mileage;

    public AbstractVehicle(String name, double baseMaintenanceCost) {
        this.name = name;
        this.baseMaintenanceCost = baseMaintenanceCost;
        this.mileage = 0;
    }
    public void move(int distance){
        mileage += distance;
    }
    public abstract double calculateFuelCost();
}
