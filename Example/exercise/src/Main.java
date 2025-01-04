import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLi quanLi = new QuanLi();

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Quản lí Hóa Đơn");
            System.out.println("------------------------------------");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Xóa khách hàng");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Thêm hóa đơn");
            System.out.println("5. Hiện thị Thông tin khách hàng");
            System.out.println("6. Hiện thị các hóa đơn chưa thanh toán");
            System.out.println("7. Hiện thị bảng giá hiện tại");
            System.out.println("8. Thoát!");
            System.out.println("Nhập lựa chọn của bạn: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    quanLi.ThemKhachHang();
                    break;
                case 2:
                    quanLi.XoaKhachHang();
                    break;
                case 3:
                    quanLi.SuaKhachHang();
                    break;
                case 4:
                    quanLi.ThemHoaDon();
                    break;
                case 5:
                    quanLi.ShowKhachHang();
                    break;
                case 6:
                    quanLi.ShowHoaDonChuaTT();
                    break;
                case 7 :
                    quanLi.ShowBangGiaDichVu();
                case 8:
                    System.out.println("Thoát Chương trình.....");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}