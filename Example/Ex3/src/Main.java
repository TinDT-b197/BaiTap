import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HospitalManager hospitalManager = new HospitalManager();
        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            // Display main menu
            System.out.println("<<==== Hospital Manager ====>>");
            System.out.println("1. Add Department");
            System.out.println("2. Add Room");
            System.out.println("3. Add Doctor");
            System.out.println("4. Add Patient");
            System.out.println("5. Admit / Discharge Patient");
            System.out.println("6. Change Room for Patient");
            System.out.println("7. Change Doctor for Patient");
            System.out.println("8. Show Patients by Disease");
            System.out.println("9. Show Patients by Room");
            System.out.println("10. Show Doctors by Department");
            System.out.println("11. Show Patients by Birth Year");
            System.out.println("12. Exit");

            System.out.print("Select an option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    hospitalManager.addDepartment();
                    break;
                case 2:
                    hospitalManager.addRoom();
                    break;
                case 3:
                    hospitalManager.addDoctor();
                    break;
                case 4:
                    hospitalManager.addPatient();
                    break;
                case 5:
                    hospitalManager.hospitalized();
                    break;
                case 6:
                    hospitalManager.changeRoom();
                   break;
                case 7:
                    hospitalManager.changeDoctor();
                    break;
                case 8:
                    hospitalManager.showPatientsSortedByDisease();
                    break;
                case 9:
                    hospitalManager.showPatientsSortedByRoom();
                    break;
                case 10:
                    hospitalManager.showDoctorsSortedByDepartment();
                    break;
                case 11:
                    hospitalManager.showPatientsSortedByYearOfBirth();
                  break;
                case 12:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}


