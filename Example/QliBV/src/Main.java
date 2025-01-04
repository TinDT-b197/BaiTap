import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        QLY qly = new QLY();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n<======== Quản lý BV ========>");
            System.out.println("1. Them Bac si ");
            System.out.println("2. Them Benh Nhan");
            System.out.println("3. Them Khoa");
            System.out.println("4. Them Phong");
            System.out.println("5. Hien thi danh sach");
            System.out.println("6. Thoát");

            System.out.print("Option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Nhap id benh nhan xuat vien: ");
                    String id = sc.nextLine();
                    boolean thanhcong = qly.XuatVien(id);
                    break;
                case 2:
                    qly.ThemBenhNhan();
                    break;
                case 3:
                    qly.ThemKhoa();
                    break;
                case 4:
                    qly.ThemPhong();
                    break;
                case 5:
                    qly.hienthidanhsach();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }
}
