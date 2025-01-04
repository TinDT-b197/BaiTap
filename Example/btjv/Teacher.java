import java.util.Scanner;

public class Teacher {
    public static void main(String[] args) {
        Person a = new Person();
        String institution_name;
        String courses;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        a.name = sc.nextLine();
        System.out.println("Enter age: ");
        a.age = sc.nextInt();
        System.out.println("Enter address: ");
        sc.nextLine();
        a.address = sc.nextLine();
        System.out.println("Enter institution name: ");
        institution_name = sc.nextLine();
        System.out.println("Enter courses: ");
        courses = sc.nextLine();

        System.out.println("name: " + a.name + "\n age: " + a.age + "\n address: " + a.address);
    }
}
