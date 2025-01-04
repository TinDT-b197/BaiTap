import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor extends Person {
    private String doctorID;
    private String departmentID;
    private List<Patient> patientList;

    public Doctor(String name, int yearOfBirth, String address, String doctorID, String departmentID) {
        super(name, yearOfBirth, address);
        this.doctorID = doctorID;
        this.departmentID = departmentID;
        this.patientList = new ArrayList<>();
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| %-10s | %-10s |",
                doctorID, departmentID);
    }

    public void modifyInfoDoctor() {
        Scanner input = new Scanner(System.in);
        boolean keepModifying = true;

        while (keepModifying) {
            System.out.println("\nSelect the information you want to edit:");
            System.out.println("1. Doctor's name");
            System.out.println("2. Year of birth");
            System.out.println("3. Address");
            System.out.println("4. Doctor ID");
            System.out.println("0. Exit!");
            System.out.print("Your selection: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    String newName = input.nextLine();
                    super.setName(newName);
                    System.out.println("Name has been updated to: " + newName);
                    break;
                case 2:
                    System.out.print("Enter new year of birth: ");
                    int newYearOfBirth = input.nextInt();
                    input.nextLine();
                    super.setYearOfBirth(newYearOfBirth);
                    System.out.println("Year of birth has been updated to: " + newYearOfBirth);
                    break;
                case 3:
                    System.out.print("Enter new address: ");
                    String newAddress = input.nextLine();
                    super.setAddress(newAddress);
                    System.out.println("Address has been updated to: " + newAddress);
                    break;
                case 4:
                    System.out.print("Enter new doctor ID: ");
                    String newDoctorID = input.nextLine();
                    setDoctorID(newDoctorID);
                    System.out.println("Doctor ID has been updated to: " + newDoctorID);
                    break;
                case 0:
                    keepModifying = false;
                    System.out.println("Exit modify info doctor!.");
                    break;
                default:
                    System.out.println("Invalid selection, please select again.");
            }
        }
    }

    public void changeDepartment(String newDepartmentID) {
        this.departmentID = newDepartmentID;
    }
}
