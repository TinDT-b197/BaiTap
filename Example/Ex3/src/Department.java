import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Department {
    private String departmentID;
    private String departmentName;
    List<Doctor> doctorList;

    public Department() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Department ID: ");
        departmentID = input.nextLine();
        System.out.println("Enter Department Name: ");
        departmentName = input.nextLine();
        doctorList = new ArrayList<>();
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void renameDepartment(String newDepartmentName) {
        this.departmentName = newDepartmentName;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctorList.remove(doctor);
    }
}
