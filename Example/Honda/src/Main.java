import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        HondaManage hondaManage = new HondaManage();
        hondaManage.ThemXe(new Vehical("Vision","1","3",2400,"20/10/2023"));
        hondaManage.ThemXe(new Vehical("Vario","2","5",4000,"20/10/2023"));
        hondaManage.ThemXe(new Vehical("Air Blade","3","2",5000,"20/10/2023"));
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n<======== Quản lý BV ========>");
            System.out.println("1. Thêm khách hàng ");
            System.out.println("2. Xếp DS người mua");
            System.out.println("3. Kiểm tra xe tồn");
            System.out.println("4. Thêm xe");
            System.out.println("5. Hien thi danh sach");
            System.out.println("6. Thoát");

            System.out.print("Option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hondaManage.ThemKhachHang();
                    break;
                case 2:
                    hondaManage.XepDSNguoiMuaTheoNgay();
                    hondaManage.InDS();
                    break;
                case 3:
                    hondaManage.KiemTraKho();
                    break;
                case 4:
                    hondaManage.ThemXe();
                    break;
                case 5:
                    System.out.println("Thoát chương trình !");
            }
        }while(choice!=5);
    }
}