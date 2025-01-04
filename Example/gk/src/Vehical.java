public interface Vehical {
    String getType();
    double calculateMaintenenceCost();
    void displayInfo();
    void move(int distance);
    void refuel(double amount);

}
