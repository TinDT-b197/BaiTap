import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HospitalManager {
    List<Department> departmentList = new ArrayList<>();
    List<Room> roomList = new ArrayList<>();

    public void addDepartment() {
        departmentList.add(new Department());
    }

    public void addDoctor() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("<=== Enter Doctor Information ===>");
            System.out.println("-> Enter the name of the doctor: ");
            String name = input.nextLine();

            System.out.println("-> Enter the yearOfBirth of the doctor: ");
            int yearOfBirth = input.nextInt();
            input.nextLine();

            System.out.println("-> Enter the address of the doctor: ");
            String address = input.nextLine();

            System.out.println("-> Enter the doctor ID: ");
            String doctorID = input.nextLine();

            System.out.println("-> Enter the department of the doctor: ");
            String departmentID = input.nextLine();

            Department matchedDepartment = findDepartmentByID(departmentID);
            if(matchedDepartment != null) {
                Doctor doctor = new Doctor(name, yearOfBirth, address, doctorID, departmentID);
                matchedDepartment.addDoctor(doctor);
                System.out.println("Doctor added successfully to department: " + matchedDepartment.getDepartmentName());
                break;
            } else {
                System.out.println("Invalid department ID! Please enter again.");
            }
        }
    }

    public void addRoom() {
        roomList.add(new Room());
    }

    public void addPatient() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("<=== Enter Patient Information ===>");
            System.out.println("-> Enter the name of the patient: ");
            String name = input.nextLine();
            System.out.println("-> Enter the yearOfBirth of the patient: ");
            int yearOfBirth = input.nextInt();
            input.nextLine();
            System.out.println("-> Enter the address of the patient: ");
            String address = input.nextLine();
            System.out.println("-> Enter the patientID: ");
            String patientID = input.nextLine();
            System.out.println("-> Enter the diseaseID: ");
            String diseaseID = input.nextLine();
            System.out.println("-> Enter the doctorID: ");
            String doctorID = input.nextLine();

            Doctor matchedDoctor = findDoctorByID(doctorID);
            if(matchedDoctor != null) {
                Patient patient = new Patient(name, yearOfBirth, address, patientID, diseaseID,
                        null, null, false, null);
                matchedDoctor.addPatient(patient);
                System.out.println("Patient added successfully to doctor: " + matchedDoctor.getName());
                break;
            } else {
                System.out.println("Invalid doctor ID! Please enter again.");
            }
        }
    }

    public void hospitalized() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter ID patient need hospitalized: ");
            String patientID = input.nextLine();

            boolean foundPatient = false;
            Patient patientToHospitalize = null;
            for (Department department : departmentList) {
                for (Doctor doctor : department.getDoctorList()) {
                    for (Patient patient : doctor.getPatientList()) {
                        if (patientID.equals(patient.getPatientID())) {
                            foundPatient = true;
                            patientToHospitalize = patient;
                            break;
                        }
                    }
                    if (foundPatient) {break;}
                }
                if (foundPatient) {break;}
            }
            if (!foundPatient) {
                System.out.println("Patient with ID " + patientID + " not found. Please try again.");
                continue;
            }

            System.out.println("Enter the room number to assign to the patient: ");
            String roomID = input.nextLine();

            Room assignedRoom = findRoomByNumber(roomID);
            if (assignedRoom == null) {
                System.out.println("Room number " + roomID + " does not exist. Please try again.");
            } else if (assignedRoom.getNumberOfPatients() == assignedRoom.getNumberOfBeds()) {
                System.out.println("Room " + roomID + " is full. Please choose another room.");
            } else {
                assignedRoom.setNumberOfPatients(assignedRoom
                .getNumberOfPatients() + 1);
                patientToHospitalize.setRoomID(roomID);

                System.out.println("Patient " + patientToHospitalize.getName() + " has been successfully hospitalized in room " + roomID);
                break;
            }
        }

    }

    public void showPatientsSortedByYearOfBirth() {
        List<Patient> sortedPatients = departmentList.stream()
                .flatMap(department -> department.getDoctorList().stream())
                .flatMap(doctor -> doctor.getPatientList().stream())
                .sorted(Comparator.comparingInt(Patient::getYearOfBirth))
                .toList();

        if (sortedPatients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\nList of Patients sorted by Year of Birth:");
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("| %-20s | %-10s | %-10s | %-4s | %-10s |\n", "Name", "PatientID", "DiseaseID", "YOB", "DoctorID");
            System.out.println("-------------------------------------------------------------------");
            for (Patient patient : sortedPatients) {
                System.out.printf("| %-20s | %-10s | %-10s | %-4d | %-10s |\n",
                        patient.getName(), patient.getPatientID(), patient.getDiseaseID(),
                        patient.getYearOfBirth(), patient.getAssignedDoctorID());
            }
            System.out.println("-------------------------------------------------------------------");
        }
    }
    public void showPatientsSortedByDisease() {
        List<Patient>sortedPatients = departmentList.stream()
                .flatMap(department -> department.getDoctorList().stream())
                .flatMap(doctor -> doctor.getPatientList().stream())
                .sorted(Comparator.comparing(Patient::getDiseaseID))
                .toList();
        if (sortedPatients.isEmpty()) {
            System.out.println("No patients found.");
        }
        else {
            System.out.println("\nList of Patients sorted by Disease:");
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("| %-20s | %-10s | %-10s | %-4s | %-10s |\n", "Name", "PatientID", "DiseaseID", "YOB", "DoctorID");
            System.out.println("-------------------------------------------------------------------");
            for (Patient patient : sortedPatients) {
                System.out.printf("| %-20s | %-10s | %-10s | %-4d | %-10s |\n",
                        patient.getName(), patient.getPatientID(), patient.getDiseaseID(),
                        patient.getYearOfBirth(), patient.getAssignedDoctorID());
            }
        }
    }
    public void showPatientsSortedByRoom() {
        List<Patient>sortedPatients = departmentList.stream()
                .flatMap(department -> department.getDoctorList().stream())
                .flatMap(doctor -> doctor.getPatientList().stream())
                .sorted(Comparator.comparing(Patient::getRoomID))
                .toList();
        if (sortedPatients.isEmpty()) {
            System.out.println("No patients found.");
        }
        else {
            System.out.println("\nList of Patients sorted by Room:");
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("| %-20s | %-10s | %-10s | %-4s | %-10s |\n", "Name", "PatientID", "DiseaseID", "YOB", "DoctorID");
            System.out.println("-------------------------------------------------------------------");
            for (Patient patient : sortedPatients) {
                System.out.printf("| %-20s | %-10s | %-10s | %-4d | %-10s |\n",
                        patient.getName(), patient.getPatientID(), patient.getDiseaseID(),
                        patient.getYearOfBirth(), patient.getAssignedDoctorID());
            }
        }
    }
    public void showDoctorsSortedByDepartment() {
        List<Doctor>doctorsSorted = departmentList.stream()
                .flatMap(department -> department.getDoctorList().stream())
                .sorted(Comparator.comparing(Doctor::getDepartmentID))
                .toList();
        if (doctorsSorted.isEmpty()) {
            System.out.println("No doctors found.");
        }
        else {
            System.out.println("\nList of Doctors sorted by Department:");
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("| %-20s | %-10s | %-10s | %-4s | %-10s |\n", "Name", "DoctorID", "YOB", "DepartmentID");
            System.out.println("-------------------------------------------------------------------");
            for (Doctor doctor : doctorsSorted) {
                System.out.printf("| %-20s | %-10s | %-10s | %-4d | %-10s |\n",
                        doctor.getName(), doctor.getDoctorID(), doctor.getYearOfBirth(),
                        doctor.getDepartmentID());
            }
        }
    }

    private Department findDepartmentByID(String departmentID) {
        for (Department department : departmentList) {
            if (department.getDepartmentID().equals(departmentID)) {
                return department;
            }
        }
        return null;
    }

    private Doctor findDoctorByID(String doctorID) {
        for (Department department : departmentList) {
            for (Doctor doctor : department.getDoctorList()) {
                if (doctor.getDoctorID().equals(doctorID)) {
                    return doctor;
                }
            }
        }
        return null;
    }

    private Room findRoomByNumber(String roomID) {
        for (Room room : roomList) {
            if (room.getRoomID().equals(roomID)) {
                return room;
            }
        }
        return null;
    }
    public void changeDoctor(){
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter ID doctor need change: ");
            String doctorID = input.nextLine();

            Doctor doctor = findDoctorByID(doctorID);
            if (doctor == null) {
                System.out.println("Doctor with ID " + doctorID + " not found. Please try again.");
                continue;
            }
            System.out.println("Enter ID patient need change Doctor: ");
            String patientID = input.nextLine();
            Patient patient =  findPatientID(patientID);
            if (patient == null) {
                System.out.println("Patient with ID " + patientID + " not found. Please try again.");
                continue;
            }
            System.out.println("Enter new doctor ID: ");
            String newDoctorID = input.nextLine();
            Doctor newDoctor = findDoctorByID(newDoctorID);
            if(newDoctor == null) {
                System.out.println("Doctor with ID " + newDoctorID + " not found. Please try again.");
                continue;
            }
            patient.setAssignedDoctorID(newDoctorID);
            System.out.println("New doctor with name " + newDoctor.getName() + " has been assigned.");
            break;
        }
    }
    private Patient findPatientID(String patientID) {
        for (Department department : departmentList) {
            for (Doctor doctor : department.getDoctorList()) {
                for (Patient patient : doctor.getPatientList()) {
                    if (patient.getPatientID().equals(patientID)) {
                        return patient;
                    }
                }
            }
        }
        return null;
    }
    public void changeRoom(){
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter ID patient need change room: ");
            String patientID = input.nextLine();
            Patient patient = findPatientID(patientID);
            if (patient == null) {
                System.out.println("Patient with ID " + patientID + " not found. Please try again.");
                continue;
            }
            System.out.println("Enter new room ID: ");
            String roomID = input.nextLine();
            Room room = findRoomByNumber(roomID);
            if (room == null) {
                System.out.println("Room with ID " + roomID + " not found. Please try again.");
                continue;
            }
            patient.setRoomID(roomID);
            System.out.println("New room with ID " + roomID + " has been assigned.");
        }
    }
}

