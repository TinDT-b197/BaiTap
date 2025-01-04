import java.util.Scanner;

public class Room {
    private String roomID;
    private String roomName;
    private int numberOfBeds;
    private int numberOfPatients;

    public Room() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Room ID: ");
        roomID = input.nextLine();
        System.out.print("Enter Room Name: ");
        roomName = input.nextLine();
        System.out.print("Enter Number of Beds: ");
        numberOfBeds = input.nextInt();
        input.nextLine();
        numberOfPatients = 0;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    public void addPatient() {
        if(numberOfPatients < numberOfBeds) {
            numberOfPatients++;
        } else {
            System.out.println("Patient is Full");
        }
    }

    public void removePatient() {
        numberOfPatients--;
    }

    public void modifyInfoRoom() {
        Scanner input = new Scanner(System.in);
        boolean keepModifying = true;

        while(keepModifying) {
            System.out.println("\nSelect the information you want to edit:");
            System.out.println("1. Room ID");
            System.out.println("2. Room name");
            System.out.println("3. Number of beds");
            System.out.println("4. Exit!");
            System.out.print("Your selection: ");

            int selection = input.nextInt();
            switch(selection) {
                case 1:
                    System.out.print("Enter Room ID: ");
                    String newID = input.nextLine();
                    setRoomID(newID);
                    System.out.println("Room ID has been updated to: " + newID);
                    break;
                case 2:
                    System.out.print("Enter Room Name: ");
                    String newName = input.nextLine();
                    setRoomName(newName);
                    System.out.println("Room Name has been updated to: " + newName);
                    break;
                case 3:
                    System.out.print("Enter Number of Beds: ");
                    int newBeds = input.nextInt();
                    setNumberOfBeds(newBeds);
                    System.out.println("Number of beds has been updated to: " + newBeds);
                    break;
                case 4:
                    keepModifying = false;
                    break;
                default:
                    System.out.println("Invalid selection, please select again.");
            }

        }
        System.out.println();
    }
}
