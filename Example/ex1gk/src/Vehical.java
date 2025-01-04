public interface Vehical {
    String getType();
    double calculateMaintenanceCost();
    void displayInfo();
    void move(int distance);
    void refuel(double amount);
}
