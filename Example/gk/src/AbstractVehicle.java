public abstract class AbstractVehicle implements Vehical {
    protected String name;
    protected double baseMaintenanceCost;
    protected int mileage;

    public AbstractVehicle(String name, double baseMaintenanceCost) {
        this.name = name;
        this.baseMaintenanceCost = baseMaintenanceCost;
        this.mileage = mileage =0;
    }

    public abstract double calculateMaintanenceCost();

    public void move(int distance){
        if(distance >0){
            mileage += distance;
        }
    }
    public abstract double calculateFuelCost(int distance);


    public String getName(){
        return name;
    }
    public double getBaseMaintenanceCost(){
        return baseMaintenanceCost;
    }
    public int getMileage(){
        return mileage;
    }
}
